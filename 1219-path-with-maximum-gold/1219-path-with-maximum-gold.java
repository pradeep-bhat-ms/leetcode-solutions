class Solution {

    int rows;
    int cols;
    int[][] grid;

    public int getMaximumGold(int[][] grid) {

        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        int maxGold = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int row, int col) {

        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            grid[row][col] == 0) {

            return 0;
        }

        int gold = grid[row][col];

 
        grid[row][col] = 0;

        int up = dfs(row - 1, col);
        int down = dfs(row + 1, col);
        int left = dfs(row, col - 1);
        int right = dfs(row, col + 1);

    
        grid[row][col] = gold;

        return gold + Math.max(
            Math.max(up, down),
            Math.max(left, right)
        );
    }
}