package 剑指offer.medium;

import java.util.Arrays;

/**
 * TODO
 *leetcode 31 下一个排序
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 官方解答：从后向前寻找第一个非降序的数字a[i]（说明之后的全部为降序），然后寻找第一个大于a[i]的数字，两者交换后讲a[i]以后的数组排序
 * @author 苞谷洁子
 * @ClassName NextPermutation
 * @date 2021/8/30 21:13
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int[] swapNums = isSwap(0,nums.length-1,nums);
        System.out.println(swapNums);
        if(swapNums == null){
            Arrays.sort(nums);
        }else{
            int temp = nums[swapNums[0]];
            nums[swapNums[0]] = nums[swapNums[1]];
            nums[swapNums[1]] = temp;
            Arrays.sort(nums,swapNums[0] + 1,nums.length);
        }
    }

    public static int[] isSwap(int start,int end,int[] nums){
        if(start >= end){
            return null;
        }
        int index = end;
        while (index >= start && nums[index] >= nums[end]){
            index --;
        }
        System.out.println("index:"+index);
        int[] swapNums = isSwap(index+1, end - 1,nums);
        if(swapNums != null){
            return swapNums;
        }else{
            if(index >= start){
                return new int[]{index,end};
            }else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
//        Arrays.sort(nums,2,nums.length);
        nextPermutation(nums);
        for(int i:nums){
            System.out.print(i + ",");
        }
    }
}
