package Graph;

public class Islands {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) { // row
            for (int j = 0; j < grid[i].length; j++) { // columns
                if (grid[i][j] == '1') {
                    islands++;
                    findAllNearMe(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void findAllNearMe(char[][] grid, int i, int j) {
        // base condition to check boundary
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        findAllNearMe(grid, i + 1, j); // up
        findAllNearMe(grid, i - 1, j); // down
        findAllNearMe(grid, i, j + 1); // right
        findAllNearMe(grid, i, j - 1); // left

    }
}