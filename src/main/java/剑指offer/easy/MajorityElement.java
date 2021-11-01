package 剑指offer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * leetcode 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author 苞谷洁子
 * @ClassName MajorityElement
 * @date 2021/10/10 15:04
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        int max = 1;
        int maxNum = nums[0];
        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            if(numsMap.containsKey(temp)){
                numsMap.put(temp,numsMap.get(temp)+1);
            }else{
                numsMap.put(temp,1);
            }
            if(numsMap.get(temp) > max){
                max = numsMap.get(temp);
                maxNum = temp;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement(nums);
        System.out.println(i);
    }
}
