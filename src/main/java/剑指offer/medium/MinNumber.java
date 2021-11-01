package 剑指offer.medium;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TODO
 * leetcode 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如：
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * @author 苞谷洁子
 * @ClassName MinNumber
 * @date 2021/10/12 16:09
 */
public class MinNumber {

    public static String minNumber(int[] nums) {
        //Stream流
        //a+b < b+a
//        String numStr = IntStream.of(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.joining());
        StringBuffer numStr = new StringBuffer();
        //用快排的思想实现 a+b < b+a的排序，将排完序的所有字符串相加
        String[] numsStr = IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.toList()).toArray(new String[0]);
        quickSort(numsStr,0,numsStr.length-1);
        for(String str:numsStr){
            numStr.append(str);
        }
        return new String(numStr);
    }

    /**
     *@author 苞谷洁子
     * @param numsStr 待排序数组
     * @param start 排序起始点
     * @param end 排序终止点
     * 假设每次以最后一个数字作为基准数
     *@return 
     *@throws
     *@date  
     */
    public static void quickSort(String[] numsStr,int start,int end){
        if(start >= end){
            return;
        }
        int i = start,j = end;
        String tempStr = numsStr[end];
        while (i<j){
            while ((numsStr[i]+tempStr).compareTo(tempStr + numsStr[i]) <= 0 && i<j){
                i++;
            }
            while ((numsStr[j]+tempStr).compareTo(tempStr + numsStr[j]) >= 0 && i<j) {
                j--;
            }
            String temp = numsStr[i];
            numsStr[i] = numsStr[j];
            numsStr[j] = temp;
        }
        String tempi = numsStr[i];
        numsStr[i] = tempStr;
        numsStr[end] = tempi;
        quickSort(numsStr,start,i-1);
        quickSort(numsStr,i+1,end);
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String s = minNumber(nums);
        System.out.println(s);
    }
}
