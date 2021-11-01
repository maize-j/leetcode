package 剑指offer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *leetCode 11 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 要使答案中不能重复，因此必须先排序
 * 1、初步断定为三重循环，由于不能重复，因此相邻的两次循环取得的三位数不能相等（从控制最后一位开始，相邻的两次循环的数不能相等）
 * 2、确定a、b的情况下，可以确定c，当a、b改变时，由于排序了，则a+b一定在增大，因此c一定在减小，c应该向前遍历，因此确定a后遍历，c向前遍历，b在a、c之间
 * (官方解答是a、b先遍历，且不允许与上一次重复，c减小递增)
 * 注意：答案中不可以包含重复的三元组
 * @author 苞谷洁子
 * @ClassName ThreeSum
 * @date 2021/8/29 16:50
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeNums = new ArrayList<>();
        if(null == nums || nums.length < 3){
            return threeNums;
        }
        int length = nums.length;
        //对数组进行排序
        Arrays.sort(nums);
        int first = 0;
        for(;first < length-2;first++){
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = length - 1;
            for(;third > first+1; third --){
                //第三位与前一次循环时相同，前移
                if(third < length - 1 && nums[third] == nums[third+1]) {
                    continue;
                }
                int temp = -(nums[first] + nums[third]);
                for(int second = first+1;second < third;second++){
                    //确定了a、c只存在一个数字满足范围，有满足范围的数字时，加入数组并break
                    if(temp == nums[second]) {
                        List<Integer> threeNum = new ArrayList<>();
                        threeNum.add(nums[first]);
                        threeNum.add(nums[second]);
                        threeNum.add(nums[third]);
                        threeNums.add(threeNum);
                        break;
                    }
                    if(nums[second] > temp){
                        break;
                    }
                }

            }
        }
        return threeNums;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,-1,-1,0,0,0,1,1,2,2,3,3,4,4};
        List<List<Integer>> threeNums = threeSum(nums);
        System.out.println(threeNums);
    }
}
