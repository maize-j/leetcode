package leetcode.middle;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * TODO
 * leetcode 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * @author 苞谷洁子
 * @ClassName Jump
 * @date 2021/10/28 18:46
 */
public class Jump {
    public static int jump(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int length = nums.length;
        int[] minPath = new int[length];
        minPath[length-1] = 0;
        minPath[length-2] = 0;
        for(int i = length-3;i>=0;i--){
            int n = nums[i];
            if(i + n >= length-1){
                minPath[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(;n>0;n--){
                if(min > minPath[i+n]){
                    min = minPath[i+n];
                }
            }
            minPath[i] = min==Integer.MAX_VALUE?min:min+1;
        }
        return minPath[0];
    }
//    public static void minJump(int[] nums,int index,int num){
//        if(index >= nums.length - 1){
//            if(min > num){
//                min = num;
//            }
//            return;
//        }
//        int temp = nums[index];
//        for(int i = 1;i<=temp;i++){
//            minJump(nums,index+i,num+1);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for(int i = 0;i<s1.length;i++){
            nums[i] = Integer.valueOf(s1[i]);
        }
        System.out.println(jump(nums));
    }
}
