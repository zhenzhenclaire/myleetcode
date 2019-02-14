package dynamic;

import java.util.List;

public class Triangle {
	
	
	public int minimumTotal1(List<List<Integer>> triangle) {
		int rowNum = triangle.size();
		if(rowNum == 0)	return 0;
		if(rowNum == 1)	return triangle.get(0).get(0);
		
		int colNum = triangle.get(rowNum - 1).size();
		int[][] temp = new int[rowNum][colNum];
		
		temp[0][0] = triangle.get(0).get(0);
		for(int i = 1;i < rowNum;i++){
			int col = triangle.get(i).size();
			for(int j = 0;j < col;j++){
				if(j == 0){
					temp[i][j] = temp[i - 1][j] + triangle.get(i).get(j);	
				}
				else if(j == col - 1){
					temp[i][j] = temp[i - 1][j - 1] + triangle.get(i).get(j);
				}
				else{
					if(temp[i - 1][j - 1] < temp[i - 1][j]){
						temp[i][j] = temp[i - 1][j - 1] + triangle.get(i).get(j);
					}
					else{
						temp[i][j] = temp[i - 1][j] + triangle.get(i).get(j);
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int j = 0; j < colNum;j++){
			if(temp[rowNum - 1][j] < min){
				min = temp[rowNum - 1][j];
			}
		}
		return min;
    }
}
