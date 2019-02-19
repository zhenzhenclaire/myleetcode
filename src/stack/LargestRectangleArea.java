package stack;

import java.util.Stack;

// 84
public class LargestRectangleArea {
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
	
	public static void main(String[] args){
		LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
		int[] heights = {4,2};
		System.out.println(largestRectangleArea.largestRectangleArea(heights));
	}
}
