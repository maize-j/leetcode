package 剑指offer.hard;

/**
 * TODO
 * leetcode 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @author 苞谷洁子
 * @ClassName MaxSlidingWindow
 * @date 2021/10/20 21:06
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int index = 0;
        int i = 0;
        for(;i<k;i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        res[index++] = max;
        for(;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }else if(max == nums[i-k]){
                max = Integer.MIN_VALUE;
                for(int n = i-k+1;n<=i;n++){
                    if(max < nums[n]){
                        max = nums[n];
                    }
                }
            }
            res[index ++] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 8;
        int[] ints = maxSlidingWindow(nums, k);
        for(int n:ints){
            System.out.print(n + "\t");
        }
    }
}
