package 剑指offer.easy;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * @author 苞谷洁子
 * @ClassName IsStraight
 * @date 2021/10/24 21:25
 */
public class IsStraight {
//    public static boolean isStraight(int[] nums) {
//        Arrays.sort(nums);
//        int num0 = 0;
//        //排序后第一位数比9大
//        if(nums[0] > 9){
//            return false;
//        }
//        for(int i = 0;i<nums.length;i++){
//            if(nums[i] == 0){
//                num0 = num0 + 1;
//                continue;
//            }
//            //从第一位数不为大小王的开始计算
//            if(i == 0 || nums[i-1] == 0){
//                continue;
//            }
//            if(nums[i] - nums[i-1] == 0){
//                return false;
//            }
//            if(nums[i] - nums[i-1] == 1){
//                continue;
//            }
//            if(nums[i] - nums[i-1] == 2 || nums[i] - nums[i-1] == 3){
//                if(num0 >= nums[i] - nums[i-1] - 1){
//                    num0 = num0 - nums[i] - nums[i-1] - 1;
//                }else{
//                    return false;
//                }
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) {
                continue; // 跳过大小王
            }
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) {
                return false; // 若有重复，提前返回 false
            }
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.valueOf(s[i]);
        }
        System.out.println(isStraight(nums));
    }
}
