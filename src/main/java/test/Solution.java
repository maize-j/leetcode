package test;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Solution
 * @date 2021/10/12 20:28
 */
public class Solution {
    public static int num = 0;
    public static int solution(int m, int n) {
        boolean[][] flag = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                flag[i][j] = false;
            }
        }
        backtrack(n,m-1,n-1,flag);
        return num;
    }
    public static void backtrack(int n,int i, int j,boolean[][] flag){
        if(i==0 && j==0){
            num = num + 1;
            return;
        }
        flag[i][j] = true;
        if(j > 0){
            if(!flag[i][j-1]){
                backtrack(n,i,j-1,flag);
            }
        }
        if(j < n-1){
            if(!flag[i][j+1]){
                backtrack(n,i,j+1,flag);
            }
        }
        if(i > 0){
            backtrack(n,i-1,j,flag);
        }
        flag[i][j] = false;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int solution = solution(m, n);
        System.out.println(solution);
    }
}
