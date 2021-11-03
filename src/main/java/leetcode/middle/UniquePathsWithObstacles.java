package leetcode.middle;

/**
 * TODO
 * leetcode 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * @author 苞谷洁子
 * @ClassName UniquePathsWithObstacles
 * @date 2021/11/2 20:31
 */
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] pathNums = new int[row][column];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }else{
            pathNums[0][0] = 1;
        }
        for(int i = 1;i<row;i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            pathNums[i][0] = 1;
        }
        for(int i = 1;i<column;i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            pathNums[0][i] = 1;
        }
        for(int m = 1;m<row;m++){
            for(int n = 1;n<column;n++){
                if(obstacleGrid[m][n] == 1){
                    pathNums[m][n] = 0;
                }else{
                    pathNums[m][n] = pathNums[m-1][n] + pathNums[m][n-1];
                }
            }
        }
        return pathNums[row-1][column-1];
    }

    public static void main(String[] args) {
//        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
//        int[][] nums = {{0,1},{0,0}};
//        int[][] nums = {{0,0,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
//        int[][] nums = {{0}};
//        int[][] nums = {{1}};
//        int[][] nums = {{0,0,0,0,0,1,0}};
        int[][] nums = {{1},{0},{0},{0},{0},{0},{0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }
}
