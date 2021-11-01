package 剑指offer.easy;

/**
 * TODO
 * leetcode 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * @author 苞谷洁子
 * @ClassName TwoSum
 * @date 2021/10/19 20:30
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        int i = 0,j = nums.length-1;
        while (i <= j){
            if(nums[i] + nums[j] == target){
                return new int[]{nums[i],nums[j]};
            }
            if(nums[i] + nums[j] > target){
                j--;
                continue;
            }
            if(nums[i] + nums[j] < target){
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] ints = twoSum(nums,3);
        System.out.println(ints[0] + "," + ints[1]);
    }
}
