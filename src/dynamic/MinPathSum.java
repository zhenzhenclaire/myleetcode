package dynamic;

// 64
public class MinPathSum {
	public int sumToEnd(int[][] grid, int i, int j, int[][] status){
		int sum = 0;
		if(status[i][j] != 0)	return status[i][j];
		if(i == grid.length - 1 && j == grid[0].length - 1){
			sum = grid[i][j];
		}
		else if(i >= grid.length - 1){
			sum = grid[i][j] + sumToEnd(grid, i, j + 1, status);
		}
		else if(j >= grid[0].length - 1){
			sum = grid[i][j] + sumToEnd(grid, i + 1, j, status);
		}
		else{
			sum = grid[i][j] + Math.min(sumToEnd(grid, i, j + 1, status), sumToEnd(grid, i + 1, j, status));
		}
		status[i][j] = sum;
		return sum;
	}
	
	public int minPathSum(int[][] grid) {
		int[][] status = new int[grid.length][grid[0].length];
		return sumToEnd(grid, 0, 0, status);
    }
}
