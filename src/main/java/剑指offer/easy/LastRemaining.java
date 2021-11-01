package 剑指offer.easy;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * @author 苞谷洁子
 * @ClassName LastRemaining
 * @date 2021/10/24 22:25
 */
public class LastRemaining {
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1){
            if(list.size() > m+index){
                list.remove(m+index-1);
                index = m+index-1;
                continue;
            }
            int last = (m + index) % list.size();
            if(last == 0){
                list.remove(list.size()-1);
                index = 0;
            }else{
                list.remove(last - 1);
                index = last - 1;
            }
        }
        return list.get(0);
    }


    public static void main(String[] args) {
//            70866
//            116922
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(lastRemaining(n, m));
    }
}
