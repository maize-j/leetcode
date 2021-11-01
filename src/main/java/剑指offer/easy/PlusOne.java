package 剑指offer.easy;

/**
 * TODO
 * 加一 LeetCode66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
 * 评论区的dalao解答
 * public int[] plusOne(int[] digits) {
 *         for (int i = digits.length - 1; i >= 0; i--) {
 *             digits[i]++;
 *             digits[i] = digits[i] % 10;
 *             if (digits[i] != 0) return digits;
 *         }
 *         digits = new int[digits.length + 1];
 *         digits[0] = 1;
 *         return digits;
 *     }
 *
 * @author 苞谷洁子
 * @ClassName PlusOne
 * @date 2020/11/1 17:06
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        //个位数是否有进位
        if(digits[digits.length - 1] == 9){
            carry = true;
        }
        for(int i = digits.length-1;i>=0;i--){
            if(carry){
                if(digits[i] == 9){
                    carry = true;
                    digits[i] = 0;
                }else{  //没有进位时，直接返回
                    digits[i] = digits[i]+1;
                    return digits;
                }
            }else{ //没有进位时，直接返回
                digits[i] = digits[i]+1;
                return digits;
            }

        }
        //最高位有进位
        if(carry){
            System.out.println(carry);
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            ints[1] = 0;
            for(int i = 2;i<=digits.length;i++){
                ints[i] = digits[i-1];
            }
            return ints;
        }
        //实际执行不到这段代码
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {8,8,9};
        int[] ints = plusOne.plusOne(digits);
        for(int num:ints){
            System.out.println(num);
        }
    }
}
