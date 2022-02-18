package leetcode.hard;

import java.util.*;

/**
 * TODO
 * leetcode 51. N皇后
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @author 苞谷洁子
 * @ClassName SolveNQueens
 * @date 2022/2/17 22:18
 */
public class SolveNQueens {

    List<List<String>> resList = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {

        for(int i = 0;i<n;i++){
            str.append(".");
        }
        int[] queue = new int[n];
        Arrays.fill(queue,-1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        nQueue(n,0,queue,column,diagonal1,diagonal2);
        return resList;
    }

    public void nQueue(int n,int index,int[] queue,Set<Integer> column,Set<Integer> diagonal1,Set<Integer> diagonal2){
        if(index == n){
            //将int[]处理为List<String>
            List<String> list = new ArrayList<>();
            for(int i:queue){
//                System.out.print(i+"\t");
                StringBuilder temp = new StringBuilder(str);
                temp.replace(i, i+1, "Q");
                System.out.println(temp);
                list.add(temp.toString());
            }
            resList.add(list);
            return;
        }
        for(int i = 0;i<n;i++){
            //同一列存在皇后
            if (column.contains(i)){
                continue;
            }
            //左上->右下斜对角存在皇后
            if(diagonal1.contains(i-index)){
                continue;
            }
            //右上->左下斜对角存在皇后
            if(diagonal2.contains(i+index)){
                continue;
            }
            //均不存在皇后
            queue[index] = i;
            column.add(i);
            diagonal1.add(i-index);
            diagonal2.add(i+index);
            nQueue(n,index+1,queue,column,diagonal1,diagonal2);
            queue[index] = -1;
            column.remove(i);
            diagonal1.remove(i-index);
            diagonal2.remove(i+index);
//            int j = 0;
//            for(;j<index;j++){
//                if(queue[j] == i || Math.abs(index-j) == Math.abs(i-queue[j])){
//                    //两个处在同一条线上
//                    break;
//                }
//            }
//            if(j == index ){
//                queue[index] = i;
//                nQueue(n,index+1,queue,column,diagonal1,diagonal2);
//                queue[index] = -1;
//            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new SolveNQueens().solveNQueens(4);
        lists.forEach(list-> {
//            list.forEach(str-> System.out.println(str));
        });

    }
}
