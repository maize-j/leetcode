package test;

import java.util.Scanner;

/**
 * TODO
 * 小七最近喜欢上了演奏太鼓
 *
 * 太鼓的乐谱中有两种音符，敲击鼓心可以演奏出“咚”音符(在乐谱中用‘o’表示)，而敲击鼓边可以演奏出“咔”音符(在乐谱中用‘x’表示)。同时，乐谱中还存在休止符(什么也不用演奏，用‘_’表示)。而乐谱则可以表示为含有‘o’、‘x’、‘_’三种字符的字符串（如”ooxx_oxxo_o_x_oox”）
 *
 * 小七的好朋友最近赠送了他一张无休止符的乐谱作为新年礼物(用由‘o’和‘x’组成的字符串表示)。小七灵机一动：如果将一些‘o’和‘x’修改为休止符，不就可以得到更多的乐谱吗？
 *
 * 小七想知道，最终他可以得到多少种困难的乐谱。
 *
 * 如果一个乐谱是困难的，那么它存在一个不含有休止符的一段，同时存在‘o’和‘x’。
 *
 * 例如，对于(“ooxxoxxo”)，本身就是困难的，如果将其改为(“oo_x__xo”)，也是困难的，因为“xo”同时含有x和o，而如果将其改为(“oo_x_xx_”)，就不是困难的。
 *
 * 两个乐谱不同，是指它们的由‘o’、‘x’、‘_’三种字符组成的字符串不同，如“o_x_”和“ox__”和“o__x”是三种不同的乐谱。
 *
 * 注意，一张乐谱可以一个休止符也没有，也可以全是休止符
 *
 * 输入第一行包含一个正整数（1<=n<=100000），表示乐谱的长度
 *
 * 输入第二行包含一个由‘o’和‘x’（均为小写）组成的字符串，表示一张无休止符的乐谱
 * @author 苞谷洁子
 * @ClassName TestBaidu
 * @date 2021/10/18 19:39
 */
public class TestBaidu1 {

    static int n = 0;

    public static int hardTime(String str){

        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean[] flag = new boolean[str.length()];
        dynamic(chars,flag,0);
        return n;

    }
    //动态规划
    public static void dynamic(char[] chars, boolean[] flag,int index){

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int i = hardTime(str);
        System.out.println(i);
    }
}
