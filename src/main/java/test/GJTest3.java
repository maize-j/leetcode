package test;

import java.util.Scanner;

/**
 * TODO
 * 共济科技
 * 3. 一列数的规则如下:   1、1、2、3、5、8、13、21、34......    求第n位数是多少，请用递归算法实现
 * @author 苞谷洁子
 * @ClassName GJTest3
 * @date 2021/10/22 14:24
 */
public class GJTest3 {

    public static int solution(int n){
        if(n <= 2){
            return 1;
        }
        return solution(n-1) + solution(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
