package leetcode.hard;

/**
 * TODO
 * leetcode 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * @author 苞谷洁子
 * @ClassName FirstMissingPositive
 * @date 2022/1/24 19:38
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int length = nums.length;
        for(int i = 0;i<length;i++){
            //将元素i放在数组的第i-1个位置上
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        int n = 0;
        while (nums[n] == n+1){
            n++;
        }
        return n+1;
        //官方解答，哈希法
        //int n = nums.length;
        //        for (int i = 0; i < n; ++i) {
        //            if (nums[i] <= 0) {
        //                nums[i] = n + 1;
        //            }
        //        }
        //        for (int i = 0; i < n; ++i) {
        //            int num = Math.abs(nums[i]);
        //            if (num <= n) {
        //                nums[num - 1] = -Math.abs(nums[num - 1]);
        //            }
        //        }
        //        for (int i = 0; i < n; ++i) {
        //            if (nums[i] > 0) {
        //                return i + 1;
        //            }
        //        }
        //        return n + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {3,4,-1,1};
        int[] nums = {1,2,0};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }

}
