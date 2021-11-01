package 剑指offer.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * 两个数组的交集 Leetcode 349
 * @author 苞谷洁子
 * @ClassName Intersection
 * @date 2020/11/2 21:22
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        Set<Integer> integers = new HashSet<Integer>();
        for(int num1:nums1){
            for(int num2:nums2){
                if(num1 == num2){
                    integers.add(num1);
                }
            }
        }
        int[] nums = new int[integers.size()];
        int i = 0;
        for (int num:integers){
            nums[i++] = num;
        }
        return nums;*/
        Set<Integer> integers1 = new HashSet<Integer>();
        Set<Integer> integers2 = new HashSet<Integer>();
        for(int num:nums1){
            integers1.add(num);
        }
        for (int num:nums2){
            integers2.add(num);
        }
        return intersectionSet(integers1,integers2);
    }

    public int[] intersectionSet(Set<Integer> integers1, Set<Integer> integers2) {
        Set<Integer> integers = new HashSet<Integer>();
        if(integers1.size() > integers2.size()){
            return intersectionSet(integers2,integers1);
        }
        for(Integer num:integers1){
            if(integers2.contains(num)){
                integers.add(num);
            }
        }
        int[] nums = new int[integers.size()];
        int index = 0;
        for (int num:integers){
            nums[index++] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] nums = intersection.intersection(num1, num2);
        for(int num:nums){
            System.out.print(num+"\t");
        }
    }
}
