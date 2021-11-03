package leetcode.middle;

/**
 * TODO
 * leetcode 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * @author 苞谷洁子
 * @ClassName MinPathSum
 * @date 2021/11/2 21:52
 */
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[] minPath = grid[0];
        for(int i = 1;i<column;i++){
            minPath[i] = minPath[i-1] + minPath[i];
        }
        for(int i = 1;i<row;i++){
            minPath[0] = minPath[0] + grid[i][0];
            for(int j = 1;j<column;j++){
                int min = Math.min(minPath[j-1],minPath[j]);
                minPath[j] = grid[i][j] + min;
            }
        }
        return minPath[column-1];
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] nums = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(nums));
    }
}
