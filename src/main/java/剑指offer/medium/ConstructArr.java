package 剑指offer.medium;

import java.util.Scanner;

/**
 * TODO
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积。
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * @author 苞谷洁子
 * @ClassName ConstructArr
 * @date 2021/10/26 19:53
 */
public class ConstructArr {

//    答案正确，但超出时间限制
//    public static int[] constructArr(int[] a) {
//        int mul = 1;
//        int[] res = new int[a.length];
//        for(int i = 0;i<a.length;i++){
//            int muli = mul;
//            for(int j = i+1;j<a.length;j++){
//                if(a[j] == 0){
//                    muli = 0;
//                    break;
//                }
//                muli *= a[j];
//            }
//            res[i] = muli;
//            if(a[i] == 0){
//                break;
//            }
//            mul = mul * a[i];
//        }
//
//        return res;
//    }

    public static int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        res[0] = 1;
        for(int i = 1;i<a.length;i++){
            res[i] = res[i-1]*a[i-1];
        }
        int temp = 1;
        for(int j = a.length-2;j>=0;j--){
            temp *= a[j+1];
            res[j] *= temp;
        }
        return res;
    }

//    public int[] constructArr(int[] a) {
//        int n = a.length;
//        int[] B = new int[n];
//        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
//            B[i] = product;
//        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
//            B[i] *= product;
//        return B;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for(int i = 0;i<s1.length;i++){
            nums[i] = Integer.valueOf(s1[i]);
        }
        int[] ints = constructArr(nums);
        for(int n:ints){
            System.out.print(n+"\t");
        }
    }
}
