package dynamic;

import java.util.Arrays;

// #85
public class MaximalRectangle {
	
	/**
	* 对每一行进行计算, 递推公式如下:
	* 每一行开始时,左边界定为0, 右边界定为COL
	* height[j]好算:
	*    如果matrix[i][j] = 0, height[j]不变
	*    如果matrix[i][j] = 1, height[j]++;
	* left[j]从左往右算:
	*    如果matrix[i][j] = 0, left[j]=0, 同时左边界变为当前j+1(因为潜在的左边界可能就在j+1)
	*    如果matrix[i][j] = 1, left[j]= max(left[j], 左边界), 哪个大取哪个.
	*    (解释: 因为我们要的是过往所有行中0到该列位置最晚遇到1的位置)
	* right[j]从右往左算:
	*    如果matrix[i][j] = 0, right[j]=COL, 同时右边界变为当前j(因为潜在的右边界就在当前j位置)
	*    如果matrix[i][j] = 1, right[j]= min(right[j], 右边界), 哪个小取哪个.
	*    (解释: 因为我们要的是过往所有行中COL-1到该列位置最早遇到0的位置)
	*/
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int COL = matrix[0].length;
		int ROW = matrix.length;
		
		int[] maxLeft = new int[COL];
		int[] minRight = new int[COL];
		int[] maxHeight = new int[COL];
		
		Arrays.fill(maxLeft, 0);
		Arrays.fill(minRight, COL);
		Arrays.fill(maxHeight, 0);
		
		int maxArea = 0;

		for(int i = 0;i < ROW;i++){
			int leftBound = 0;
			int rightBound = COL;
			
			System.out.println("left in line:" + i);
			for(int j = 0;j < COL;j++){
				if(matrix[i][j] == '1'){
					maxLeft[j] = Math.max(maxLeft[j], leftBound);
				}
				else{
					maxLeft[j] = 0;
					leftBound = j + 1;
				}
				System.out.print(maxLeft[j]);
			}
			System.out.println();
			
			System.out.println("right in line:" + i);
			for(int j = COL - 1 ;j >= 0;j--){
				if(matrix[i][j] == '1'){
					minRight[j] = Math.min(minRight[j], rightBound);
				}
				else{
					rightBound = j;
					minRight[j] = COL;
				}
				System.out.print(minRight[j]);
			}
			System.out.println();
			
			System.out.println("height in line:" + i);
			for(int j = 0;j < COL;j++){
				if(matrix[i][j] == '1'){
					maxHeight[j] = maxHeight[j] + 1;
				}
				else{
					maxHeight[j] = 0;
				}
				System.out.print(maxHeight[j]);
			}
			System.out.println();
			System.out.println("---------------");
			
			
			for(int j = 0;j < COL;j++){
				maxArea = Math.max((minRight[j] - maxLeft[j]) * maxHeight[j], maxArea);
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		MaximalRectangle rectangle = new MaximalRectangle();
		char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},
				{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
		System.out.println(rectangle.maximalRectangle(matrix));
		
	}
}
