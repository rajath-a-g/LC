package Amazon;

public class UniquePaths2 {
    public static void main(String[] args) {
        System.out.println("Num unique paths:" + uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                path[i][0] = 0;
                break;
            } else
                path[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                path[0][i] = 0;
                break;
            } else
                path[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    path[i][j] = 0;
                else
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
}
