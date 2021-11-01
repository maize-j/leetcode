package 剑指offer.easy;

/**
 * TODO
 * 回文数 LeetCode 9
 * 判断输入的整数(可能为负数)是回文数
 * 当为负数时肯定不是回文数，例如-121，取反序列后为121-
 * 不将数组转换为字符串来解决这个问题
 * LeetCode给出的标准
 * public boolean isPalindrome(int x) {
 *         // 特殊情况：
 *         // 如上所述，当 x < 0 时，x 不是回文数。
 *         // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
 *         // 则其第一位数字也应该是 0
 *         // 只有 0 满足这一属性
 *         if (x < 0 || (x % 10 == 0 && x != 0)) {
 *             return false;
 *         }
 *
 *         int revertedNumber = 0;
 *         while (x > revertedNumber) {
 *             revertedNumber = revertedNumber * 10 + x % 10;
 *             x /= 10;
 *         }
 *
 *         // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
 *         // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
 *         // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
 *         return x == revertedNumber || x == revertedNumber / 10;
 *     }
 * @author 苞谷洁子
 * @ClassName IsPalindrome
 * @date 2020/10/27 16:05
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //x为小于0的数，一定不是回文数
        if(x < 0){
            return false;
        }
        //x为个位数，是回文数
        if(x/10 == 0){
            return true;
        }
        //x为整10的数，一定不是回文数
        if (x % 10 == 0){
            return false;
        }
        int rev = 0;
        int y = x;
        while (x != 0){
            rev = rev*10 + x%10;
            x = x/10;
            //x的位数为偶数的情况，可以这样判断
            if(rev == x) return true;
        }
        //这里要注意数据越界的问题
        //如果是回文数，反转后的数据也是可以表示
        //如果不是回文数，反转后的数据即使越界也不会等于原始的数据，得到的结果也是false
        if(rev == y){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        int a = 21120;
        boolean palindrome = isPalindrome.isPalindrome(a);
        System.out.println(palindrome);
    }
}
