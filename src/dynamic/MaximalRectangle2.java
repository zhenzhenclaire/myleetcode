package dynamic;

import java.util.Arrays;
import java.util.Stack;

// #85(second solution)
// https://www.cnblogs.com/lupx/archive/2015/10/20/leetcode-85.html
public class MaximalRectangle2 {
	
	public int largestRectangleArea(int[] heights) {
        int area = 0;
        
        Stack<Integer> hisStatck = new Stack<>();
        
        for(int i = 0;i < heights.length;i++){
        	int count = 0;
        	
        	// 如果新的数比栈顶高，那么是递增序列，直接入栈
        	if(hisStatck.isEmpty() || heights[i] >= hisStatck.peek()){
        		hisStatck.push(heights[i]);
        	}
        	// 如果新的数比栈顶低，那么要出栈，直到新数比栈顶高了
        	else{
        		// 依次出栈的数是一个递减序列，因为栈中的数是递增的，出来的就是倒序递减的。
        		// 出栈的数本身也要算面积，依次比较{第一个出栈的数}*1，{第二个出栈的数}*2……
        		while(!hisStatck.isEmpty() && heights[i] < hisStatck.peek()){
        			count++;
        			area = Math.max(area, hisStatck.pop() * count);
        		}
        		// 出栈结束需要用新数把出栈的位置填平
        		while(count-- > 0){
        			hisStatck.push(heights[i]);
        		}
        		hisStatck.push(heights[i]);
        	}
//        	System.out.println(hisStatck.toString());
        }
        
        // 对最后形成的栈中的递增序列计算面积，依次比较{第一个出栈的数}*size，{第二个出栈的数}*(size-1)……
        int size = 1;
        while(!hisStatck.isEmpty()){
        	area = Math.max(area, hisStatck.pop() * size++);
        }
        
        return area;
    }
	
	// 将矩阵分拆给每一行，每行根据84题直方图的解法计算最大面积
	// 将每一行的结果乘以height数组，计算出总体最大面积
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0) 	return 0;
		int maxArea = 0;
		int COL = matrix[0].length;
		int ROW = matrix.length;
		
		int[] height = new int[COL];
		Arrays.fill(height, 0);
		
		for(int i = 0;i < ROW;i++){
			for(int j = 0;j < COL;j++){
				if(matrix[i][j] == '0'){
					height[j] = 0;
				}
				else{
					if(height[j] == 0){
						height[j] = 1;
					}
					else{
						height[j]++;
					}
				}
			}
//			System.out.println(Arrays.toString(height));
			maxArea = Math.max(maxArea, largestRectangleArea(height));
		}
		
		return maxArea;
	}
	
	public static void main(String[] args){
		MaximalRectangle2 rectangle = new MaximalRectangle2();
		char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},
				{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
		System.out.println(rectangle.maximalRectangle(matrix));
		
	}
}
