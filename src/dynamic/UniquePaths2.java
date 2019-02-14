package dynamic;

//63
public class UniquePaths2 {
	
	public int pathNum(int m,int n,int row, int col,int[][] obstacleGrid, int[][] visited){
		int num = 0;
		if(row > m || col > n || obstacleGrid[row][col] == 1)	return 0;
		if(row == m && col == n){
			visited[row][col] = 1;
			return 1;
		}
		if(visited[row][col] != 0)	return visited[row][col];
		
		num = pathNum(m,n,row + 1, col, obstacleGrid, visited) + pathNum(m,n,row, col + 1, obstacleGrid, visited);
		visited[row][col] = num;
		return num;
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] visited = new int[obstacleGrid.length][obstacleGrid[0].length];
		int m = obstacleGrid.length - 1;
		int n = obstacleGrid[0].length - 1;
		return pathNum(m, n, 0, 0, obstacleGrid, visited);
    }
	
}
