package test;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Solution
 * @date 2021/10/12 20:28
 */
public class Solution {

    private int a;
    private int b;

    public Solution(int a ,int b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
//        short i = 1;
////        i= i+1; //需要显示的类型转换 i = (short) i+1;
//        i += 1; //自动执行了隐式类型转化
//        i++; //自动执行了隐式类型转化
//
//        String a = "a";
//
//        switch(a){
//            case "a":break;
//            case "b":break;
//        }
        int a = 1;
        int b = 2;
        Solution solution = new Solution(a,b);
        Solution solution1 = new Solution(a,b);
        System.out.println(solution.equals(solution1));

    }
}
