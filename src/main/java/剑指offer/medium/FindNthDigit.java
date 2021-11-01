package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 * @author 苞谷洁子
 * @ClassName FindNthDigit
 * @date 2021/10/11 19:45
 */
public class FindNthDigit {
    public static int findNthDigit(int n) {
        /**数字        位数      能表示的数字个数
         *1-9           1             9
         *10-99         2            180
         *100-999       3            2700
         *start-end    digit         9*start*digit
         */
        //1.找位数
        long count = 9;
        long start = 1;
        int digit = 1;
        while (count < n){
            n = (int) (n-count);
            start = start * 10;
            digit = digit + 1;
            count = 9 * start * digit;
        }
        System.out.println(digit);
        //2.找数字
        long num = start + (n -1)/digit;
        System.out.println(num);
        //3.找出所在数字的第几位
        String numsStr = String.valueOf(num);
        int index = (n - 1)%digit;
        int res = numsStr.charAt(index) - '0';
        return res;
    }

    public static void main(String[] args) {
        int n = 189;
        int nthDigit = findNthDigit(n);
        System.out.println(nthDigit);
    }
}
