package 剑指offer.easy;

/**
 * TODO
 * 最大子序和 LeetCode 53
 * @author 苞谷洁子
 * @ClassName MaxSubArray
 * @date 2020/10/30 19:27
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0){ //累加和大于0时，一直向后累加
                sum += num;
            }else{ //累加和小于0时，重新计算累加和
                sum = num;
            }
            //res中保存的是最大子序和，当有更大的出现时，就更新为最大的
            res = Math.max(sum,res);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,5};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println("最大子序和："+i);
    }
}
