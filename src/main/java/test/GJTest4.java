package test;

import java.util.Scanner;

/**
 * TODO
 * 共济科技
 * 4. 假定一种编码的编码范围是a-y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，
 * 形成一个数组如下：a,aa,aaa,aaaa,aaab,aaac,.....,....,b,ba,baa,baaa,baab,baac,... ...,yyyw,yyyx,yyyy；
 * 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。请编写程序，输入是任意一个编码，输出这个编码对应的index，例如：输入：baca输出：16328
 * @author 苞谷洁子
 * @ClassName GJTest4
 * @date 2021/10/22 14:24
 */
public class GJTest4 {

    public static int solution(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int length = str.length();
        int index = length - 1;
        int value = 0;
        while (index >= 0){
            int num = str.charAt(index) - 'a';
            int tempIndex = length - 1 - index;
            int tempNum = 1;
            for(int i = 0;i<tempIndex;i++){
                tempNum *= 25;
            }
            value += num * tempNum;
            index --;
        }
        return value;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int solution = solution(s);
        System.out.println(solution);
    }
}
