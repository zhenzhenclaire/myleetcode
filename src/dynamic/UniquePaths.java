package dynamic;

//62
public class UniquePaths {
	
	public int pathNum(int row, int col, int m, int n, int[][] visited){
		int num = 0;
		if(visited[row][col] != 0)	return visited[row][col];
		if(row == m - 1 && col == n - 1){
			visited[row][col] = 1;
			return 1;
		}
		else if(row >= m - 1){
			num = pathNum(row, col + 1, m, n, visited);
			visited[row][col] = num;
			return num;
		}
		else if(col >= n - 1){
			num = pathNum(row + 1, col, m, n, visited);
			visited[row][col] = num;
			return num;
		}
		else{
			num = pathNum(row + 1, col, m, n, visited) + pathNum(row, col + 1, m, n, visited);
			visited[row][col] = num;
			return num;
		}
	}
	
	public int uniquePaths(int m, int n) {
		int[][] visited = new int[m][n];
		return pathNum(0, 0, m, n, visited);
    }
}
