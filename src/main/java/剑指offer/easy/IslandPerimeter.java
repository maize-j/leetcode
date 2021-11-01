package 剑指offer.easy;

/**
 * TODO
 * 岛屿的周长 LeetCode463
 * @author 苞谷洁子
 * @ClassName IslandPerimeter
 * @date 2020/10/30 9:51
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int grith = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if(grid[i][j] == 0){
                    continue;
                }
                //正方形的上边界
                //陆地在第一行或者陆地的上一行为湖，周长+1
                if(i == 0 || grid[i-1][j] == 0){
                    grith += 1;
                }
                //正方形的左边界
                //陆地在第一列或者陆地的前一列为湖，周长+1
                if(j == 0 || grid[i][j-1] == 0){
                    grith += 1;
                }
                //正方形的下边界
                //陆地在最后一行或者陆地的下一行为湖，周长+1
                if(i == grid.length-1 || grid[i+1][j] == 0){
                    grith += 1;
                }
                //正方形的右边界
                //陆地在最后一列或者陆地的下一列为湖，周长+1
                if(j == grid[i].length-1 || grid[i][j+1] == 0){
                    grith += 1;
                }
            }
        }
        return grith;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int i = islandPerimeter.islandPerimeter(grid);
        System.out.println("岛屿的边长为："+i);
    }
}
