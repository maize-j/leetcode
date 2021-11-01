package 剑指offer.easy;

/**
 * TODO
 * leetcode 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * @author 苞谷洁子
 * @ClassName Search
 * @date 2021/10/16 20:50
 */
public class Search {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1]){
            return 0;
        }
        int index = 0;
        while (index < nums.length && nums[index] != target){
            index ++;
        }
        if(index >= nums.length){
            return 0;
        }
        int n = 0;
        while (index < nums.length && nums[index] == target){
            n ++;
            index ++;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int search = search(nums, 8);
        System.out.println(search);
    }
}
