package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO
 * 小明最近喜欢玩数字游戏，他善于对数字进行一系列不同的操作变化。包含如下：
 *
 * 1、 将数字加上[1,a]中任意一个数
 *
 * 2、 将数字乘[1,b]中任意一个数
 *
 * 游戏的乐趣在于将这些数字从1变到n可以有很多种不同的策略，通过加或者乘不同的数字来达到目标，但是作为一个聪明的学生，小明希望找到一个最快的方式。小明想知道将数字从1变到n，至少需要多少次操作？
 *
 * 第一行三个整数t,a,b，表示询问次数，以及a,b大小，1<=t,a,b<=1000
 *
 * 第二行t个整数，对于每个整数，需要计算最少需要多少次操作，任意数字大小范围[1,20000]。
 *
 * 数字间两两有空格隔开
 * @author 苞谷洁子
 * @ClassName TestBaidu2
 * @date 2021/10/18 19:39
 */
public class TestBaidu2 {

    static Map<Integer,Integer> map;

    public static int[] minTimes(int a,int b,int[] nums){
        int[] res = new int[nums.length];
        map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            res[i] = minTime(a,b,nums[i]);
        }
        return res;
    }

    public static int minTime(int a,int b,int num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        if(num <= a){
            map.put(num,1);
            return 1;
        }
        int min = Integer.MAX_VALUE;
//        for(int i = a;i>0;i--){
//            if(!map.containsKey(num-i)){
//                map.put(num-i,minTime(a,b,num-i));
//            }
//            min = Math.min(min,map.get(num-i) + 1);
//        }
        for(int i = b;i>1;i--){
            int time;
            if(num%b == 0){
                if(!map.containsKey(num/b)){
                    map.put(num/b,minTime(a,b,num/b));
                }
                time = map.get(num/b) + 1;
            }else{
                int temp = num%b;
                if(temp <= a){
                    if(!map.containsKey((num-num%b)/b)){
                        map.put((num-num%b)/b,minTime(a,b,(num-num%b)/b));
                    }
                    time = map.get((num-num%b)/b) + 1;
                }else{
                    if(!map.containsKey(num-a)){
                        map.put(num-a,minTime(a,b,num-a));
                    }
                    time = map.get(num-a) + 1;
                }
            }
            min = Math.min(min,time);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = t;
        int[] nums = new int[t];
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int[] ints = minTimes(a, b, nums);
        String str = "";
        for(int i:ints){
            str = str + i + "\t";
        }
        System.out.println(str.trim());
//        map = new HashMap<>();
//        System.out.println(minTime(10, 3, 36));
    }
}
