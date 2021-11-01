package 剑指offer.easy;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Add
 * @date 2021/10/25 22:01
 */
public class Add {
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        System.out.println(add(i, j));
    }
}
