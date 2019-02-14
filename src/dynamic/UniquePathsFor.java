package dynamic;

//63
public class UniquePathsFor {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] visited = new int[m][n];
		
		for(int row = m - 1;row >= 0;row--){
			for(int col = n - 1;col >= 0;col--){
				if(obstacleGrid[row][col] == 1){
					visited[row][col] = 0;
					continue;
				}
				if(row == m - 1 && col == n -1){
					visited[row][col] = 1;
					continue;
				}
				
				int down = 0;
				int right = 0;
				if(row != m - 1){
					down = visited[row + 1][col]; 
				}
				if(col != n - 1){
					right = visited[row][col + 1];
				}
				visited[row][col] = right + down ;
			}
		}
		return visited[0][0];
    }
	
}
