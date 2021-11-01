package test;

import java.util.*;

/**
 * TODO
 * 富途
 * 给定数组，返回排序后两个数的最大差值
 * 如：[9, 3, 1, 10]，返回6
 * 如：[5,5,5,5]，返回0
 * 要求空间复杂度和时间复杂度均为O(n)
 * @author 苞谷洁子
 * @ClassName FTTest1
 * @date 2021/10/21 19:17
 */
public class FTTest1 {

    public int maxDistance (int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        // write code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for(int i = 0;i<arr.length;i++){
            priorityQueue.offer(arr[i]);
        }
        int max = Integer.MIN_VALUE;
        int temp1 = priorityQueue.poll();
        while (priorityQueue.size() > 0){
            int temp2 = priorityQueue.poll();
            if(max < Math.abs(temp1 - temp2)){
                max = Math.abs(temp1 - temp2);
            }
            temp1 = temp2;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = sc.nextLine();
        String[] split = str.split("[, \\[\\]]");
        for(String s:split){
            if("".equals(s)){
                continue;
            }
            list.add(Integer.valueOf(s));
        }
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        int i = new FTTest1().maxDistance(nums);
        System.out.println(i);
    }
}
