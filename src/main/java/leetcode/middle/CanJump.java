package leetcode.middle;

import java.util.Scanner;

/**
 * TODO
 * leetcode 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @author 苞谷洁子
 * @ClassName CanJump
 * @date 2021/10/28 19:42
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length<=1){
            return true;
        }
        int length = nums.length;
        boolean[] isArrived = new boolean[length];
        isArrived[length-1] = true;
        for(int i = length -2;i>=0;i--){
            int temp = nums[i];
            if(i + temp >= length-1){
                isArrived[i] = true;
                continue;
            }
            while (temp >= 0){
                if(isArrived[i+temp] == true){
                    isArrived[i] = true;
                    break;
                }
                temp --;
            }
        }
        return isArrived[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for(int i = 0;i<s1.length;i++){
            nums[i] = Integer.valueOf(s1[i]);
        }
        System.out.println(canJump(nums));
    }
}
