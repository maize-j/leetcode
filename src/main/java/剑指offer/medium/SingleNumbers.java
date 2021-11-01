package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @author 苞谷洁子
 * @ClassName SingleNumbers
 * @date 2021/10/17 22:25
 */
public class SingleNumbers {
//    public static int[] singleNumbers(int[] nums) {
//        Arrays.sort(nums);
//        int[] res = new int[2];
//        int index = 0;
//        for(int i = 0;i<nums.length;i++){
//            if(index == 2){
//                return res;
//            }
//            if(i < nums.length-1 && nums[i] == nums[i+1]){
//                i++;
//            }else{
//                res[index ++] = nums[i];
//            }
//        }
//        return res;
//    }
    //官方解答
    /**
     *先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     *
     * 在异或结果中找到任意为 1 的位。
     *
     * 根据这一位对所有的数字进行分组。
     *
     * 在每个组内进行异或操作，得到两个数字。
     */
    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,10,4,1,4,3,3};
        int[] ints = singleNumbers(nums);
        for(int n:ints){
            System.out.print(n + "\t");
        }
    }
}
