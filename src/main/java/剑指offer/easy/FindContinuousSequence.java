package 剑指offer.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * leetcode 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @author 苞谷洁子
 * @ClassName FindContinuousSequence
 * @date 2021/10/19 20:40
 */
public class FindContinuousSequence {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        for(int i = 1;i<=target/2;i++){
            int sum = i;
            int j = i+1;
            while (sum < target){
                sum = sum + j ++;
            }
            if(sum == target){
                int[] tempNum = new int[j-i];
                int index = 0;
                for(int n = i;n<j;n++){
                    tempNum[index++] = n;
                }
                resList.add(tempNum);
            }
        }
        int[][] res = resList.toArray(new int[0][]);
        return res;
    }

    public static void main(String[] args) {
//        int target = 10;
//        int target = 9;
        int target = 15;
        int[][] continuousSequence = findContinuousSequence(target);
        for(int i = 0;i<continuousSequence.length;i++){
            for (int num:continuousSequence[i]){
                System.out.print(num+"\t");
            }
            System.out.println();
        }
    }

}
