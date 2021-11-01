package 剑指offer.easy;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 解法一：排序，取前k个数
 * 解法二：大根堆维护，如果有小于堆顶的，就替换掉堆顶，并重新排序
 * @author 苞谷洁子
 * @ClassName GetLeastNumbers
 * @date 2021/10/11 18:30
 */
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length <= k){
            return arr;
        }
        if(k<1){
            return new int[0];
        }
        //大根堆，最大的在队头，倒序
        Queue<Integer> numsQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        //前k位先维护为一个大根堆，从第k+1位开始遍历
        for(;i<k;i++){
            numsQueue.offer(arr[i]);
        }
        for(;i<arr.length;i++){
            //堆顶元素
            int temp = numsQueue.peek();
            if(arr[i] < temp){
                numsQueue.remove();
                numsQueue.offer(arr[i]);
            }
        }
        int[] resultNums = numsQueue.stream().mapToInt(Integer::intValue).toArray();
        return resultNums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
//        int k = 2;
        int k = 0;
        int[] leastNumbers = getLeastNumbers(nums, k);
        for(int i:leastNumbers){
            System.out.print(i + "\t");
        }
    }
}
