package 剑指offer.easy;

/**
 * TODO
 * leetcode 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @author 苞谷洁子
 * @ClassName MissingNumber
 * @date 2021/10/16 21:26
 */
public class MissingNumber {
    //从末位开始比较，不相等时，说明是该数字
    public static int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int index = nums.length - 1;
        while (nums[index] == n && index >= 0){
            index --;
            n--;
        }
        if(index < 0){
            return 0;
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,3};
        int[] nums = {0,1,2,3,4,5,6,7,9};
        int i = missingNumber(nums);
        System.out.println(i);
    }
}
