package leetcode.middle;

import java.util.Scanner;

/**
 * TODO
 * leetcode 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * @author 苞谷洁子
 * @ClassName UniquePaths
 * @date 2021/10/28 20:42
 */
public class UniquePaths {
//    static int path = 0;
    public static int uniquePaths(int m, int n) {
//        path(m,n,0,0);
        int[][] path = new int[m][n];
        path[0][0] = 0;
        for(int i = 1;i<m;i++){
            path[i][0] = 1;
        }
        for(int j = 1;j<n;j++){
            path[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j = 1;j<n;j++){
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }

//    public static void path(int m,int n,int start,int end){
//        if(start == m-1 || end == n-1){
//            path = path + 1;
//            if(path > 2*10e9){
//                path = 2*(int)10e9;
//            }
//            return;
//        }
//        if (start < m-1){
//            path(m,n,start+1,end);
//        }
//        if(end < n-1){
//            path(m,n,start,end+1);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(uniquePaths(m, n));
    }
}
