package 剑指offer.medium;

import java.util.Arrays;

/**
 * TODO
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 苞谷解法： 击败11% 。。。。。
 * 不用相同的组合比较
 * 确定两个数后，另一个指针遍历时存在更不接近的组合时不再向后比较
 * 确定两边的数，中间的数滑动比较
 *
 * 官方解法：结合三数之和（ThreeSum）和装水最多的容器（MaxArea）
 * 确定第一个数，当a+b+c < target b后移
 * 当a+b+c > target c前移
 * @author 苞谷洁子
 * @ClassName ThreeSumClosest
 * @date 2021/8/29 21:26
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length <= 2){
            return nums.length == 1 ? nums[1] : nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int length = nums.length;
        int first = 0;
        int sum = nums[first]+nums[first+1]+nums[nums.length - 1];
        int gap = Math.abs(nums[first]+nums[first+1]+nums[nums.length - 1] - target);
        for(;first < length - 2;first ++){
            int second = first + 1;
            int third = length - 1;
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            while (second < third){
                int tempSum = nums[first] + nums[second] + nums[third];
                if(tempSum == target){
                    return tempSum;
                }
                if(Math.abs(tempSum-target) < gap){
                    gap = Math.abs(tempSum - target);
                    sum = tempSum;
                }
                if(tempSum < target){
                    second ++;
                }else{
                    third --;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {1,5,8,9,1,-2,-5,-4,-6,3,2,3,4,5,6,7};
        int[] nums = {-1,2,1,-4};
//        int target = 9;
        int target = 1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }
}
