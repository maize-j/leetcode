package test;

import java.util.Scanner;

/**
 * TODO
 * 富途
 * n+1层楼，第一层为0，k个棋子
 * 求在最差情况下算出临界值使用的最少次数
 * @author 苞谷洁子
 * @ClassName FTTest2
 * @date 2021/10/21 19:58
 */
public class FTTest2 {

    //以下是错误解答
    public int solve (int n, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<=n;i++){
            if(min > bfs(i,i+1,k,n)){
                min = bfs(i,i+1,k,n);
            }
        }
        return min;
    }
    public int bfs(int start,int nextAdd,int left,int n){
        if(nextAdd == 0){
            nextAdd = start;
        }
        if(start >= n){
            return 1;
        }
        if(left == 1){
            return n-start;
        }
        int unBreak = bfs(start + nextAdd,nextAdd - 1,left,n);
        int breaked = bfs(start - nextAdd+1,nextAdd/2,left-1,n);
        int time = Math.min(unBreak,breaked) + 1;
        return time;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int solve = new FTTest2().solve(n, k);
        System.out.println(solve);
    }
}
