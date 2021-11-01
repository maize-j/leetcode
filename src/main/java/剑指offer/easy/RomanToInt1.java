package 剑指offer.easy;

/**
 * TODO LeetCode 13
 * 罗马数字转整数问题LeetCode中的优秀解法，用时 99.93%，内存98.73%，简单解法
 * 解题中的弊端：未对不合法的罗马字符串进行处理
 * 前面一个数比当前数小就做减法，否则做加法
 * @author 苞谷洁子
 * @ClassName RomanToInt1
 * @date 2020/10/27 18:33
 */
public class RomanToInt1 {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInt1 romanToInt1 = new RomanToInt1();
        int im = romanToInt1.romanToInt("IM"); //程序未对不合法的罗马字符串进行处理
        System.out.println(im);
    }
}
