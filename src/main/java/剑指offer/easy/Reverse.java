package 剑指offer.easy;

/**
 * TODO
 * 整数反转 LeetCode 7
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 着重注意数据越界问题 （以下为LeetCode给出的标准答案）
 * public int reverse(int x) {
 *         int rev = 0;
 *         while (x != 0) {
 *             int pop = x % 10;
 *             x /= 10;
 *             if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
 *             if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
 *             rev = rev * 10 + pop;
 *         }
 *         return rev;
 *     }
 *
 * @author 苞谷洁子
 * @ClassName Solution
 * @date 2020/10/27 14:52
 */
class Reverse {
    public int reverse(int x) {
        int[] max = {2,1,4,7,4,8,3,6,4,7};
        boolean flag = false;
        if(x<0){
            if(x == -Math.pow(2,31)){
                return 0;
            }
            x = -x;
            //用于标记x为正数还是负数
            flag = true;
        }
        int[] a = new int[100];
        int i = 0;
        while(x/10 > 0){
            a[i++] = x%10;
            x = x/10;
        }
        //i同时记录了输入的数有多少位
        a[i] = x;
        if(i>9){
            return 0;
        }else if (i == 9){
            int sumMax = 0;
            int sumA = 0;
            int n = 0;
            boolean equal = true;
            for(;n<9;n++){
                if (max[n] != a[n]){
                    equal = false;
                }
                sumMax = sumMax*10 + max[n];
                sumA = sumA*10 + a[n];
                if(sumMax > sumA){
                    break;
                }
            }
            if (n == 9){
                //前面的九位都是相同的，比较最后一位（最后一位若在循环中比较会出现越界现象）
                if(equal){
                    if (max[n] < a[n]){
                        return 0;
                    }
                }else{
                    return 0;
                }
            }
        }
        int sum = 0;
        for(int j = 0;j<=i;j++){
            sum = (sum * 10) + a[j];
        }
        //flag为true说明原本输入的x为负数
        if(flag){
            //negate()为取当前大数的相反数
            sum = -sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
//        int reverse = solution.reverse(1534236469);
//        int reverse = solution.reverse(2147483412);
        int reverseNum = reverse.reverse(-2147483648);
        System.out.println(reverseNum);
        System.out.println(Math.pow(2,31)-1);
        System.out.println(-Math.pow(2,31));
    }
}
