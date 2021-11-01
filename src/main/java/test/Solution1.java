package test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Solution1
 * @date 2021/10/13 17:30
 */
public class Solution1 {
    public static int[] findElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] rightMin = new int[nums.length];
        int min = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; --i) {
            rightMin[i] = min;
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for(int num:rightMin){
            System.out.print(num+"\t");
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                if(nums[i] < rightMin[i]) {
                    list.add(nums[i]);
                }
            }
        }

        return list.stream().parallel().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,6,9,7,10,12};
        int[] elements = findElements(nums);
        System.out.println();
        for(int n:elements){
            System.out.print(n+"\t");
        }
    }
}
