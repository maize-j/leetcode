package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @author 苞谷洁子
 * @ClassName SingleNumber
 * @date 2021/10/19 19:35
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {

        int[] k = new int[32];
        for(int a:nums){
            for(int i = 0;i<32;i++){
                k[i] += (a >> i) & 1;
            }
        }
        int res = 0;
        for(int i = 31;i>=0;i--){
            res = res << 1;
            res += (k[i]%3 == 0?0:1);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {7,9,9,9,6,6,6,5,5,5};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}
