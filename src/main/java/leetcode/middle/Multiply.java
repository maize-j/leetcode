package leetcode.middle;

/**
 * TODO
 * leetcode 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * @author 苞谷洁子
 * @ClassName Multiply
 * @date 2022/1/25 17:42
 */
public class Multiply {
    public static String multiply(String num1, String num2) {

        int[] tempStr = new int[num2.length()+num1.length()];
        for(int i = num2.length()-1;i>=0;i--){
            for(int j = num1.length()-1;j>=0;j--){
                int temp = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                temp += tempStr[i+j+1];
                tempStr[i+j+1] = temp%10;
                tempStr[i+j] += temp/10;
            }
        }
        StringBuilder result = new StringBuilder("");
        int index = 0;
        while (index<tempStr.length && tempStr[index] == 0){
            index++;
        }
        for(;index<tempStr.length;index++){
            result.append(tempStr[index]);
        }
        return result.toString().length() == 0?"0":result.toString();
    }

    public static void main(String[] args) {
//        String num1 = "50";
//        String num2 = "5";
        String num1 = "0";
        String num2 = "0";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }
}
