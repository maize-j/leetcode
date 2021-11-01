package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 动态规划 f(m,n) = value(m,n) + Max(f(m-1,n),f(m,n-1))
 * @author 苞谷洁子
 * @ClassName MaxValue
 * @date 2021/10/13 21:30
 */
public class MaxValue {
    static int row,column;
    static int[][] maxValue;

    public static int maxValue(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        maxValue = new int[row][column];
        return dynamic(grid,0,0);
    }

    public static int dynamic(int[][] grid,int m,int n){
        if(m == row-1 && n == column-1){
            return grid[m][n];
        }
        if(m == row-1){
            if(maxValue[m][n+1] <= 0){
                maxValue[m][n+1] = dynamic(grid,m,n+1);
            }
            return grid[m][n] + maxValue[m][n+1];
        }
        if(n == column-1){
            if(maxValue[m+1][n] <= 0){
                maxValue[m+1][n] = dynamic(grid,m+1,n);
            }
            return grid[m][n] + maxValue[m+1][n];
        }
        if(maxValue[m][n+1] <= 0){
            maxValue[m][n+1] = dynamic(grid,m,n+1);
        }
        if(maxValue[m+1][n] <= 0){
            maxValue[m+1][n] = dynamic(grid,m+1,n);
        }
        return grid[m][n] + Math.max(maxValue[m][n+1],maxValue[m+1][n]);
    }

    public static void main(String[] args) {

        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int value = maxValue(grid);
        System.out.println(value);
    }
}
