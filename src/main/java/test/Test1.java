package test;


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName test.Test1
 * @date 2021/9/8 23:33
 */
public class Test1 {

    public static int f(int a, int n, int q) {
        int result = a;
        int b = a;
        for (int i=1; i<=n; i++) {
            b *= q;
            result += b;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(f(3, 10, 2));

    }
}
