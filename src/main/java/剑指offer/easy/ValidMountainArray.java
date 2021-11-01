package 剑指offer.easy;

/**
 * TODO
 * 有效的山脉数组 Leetcode 941
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得
 * LeetCode的官方解答
 * public boolean validMountainArray(int[] A) {
 *         int N = A.length;
 *         int i = 0;
 *
 *         // 递增扫描
 *         while (i + 1 < N && A[i] < A[i + 1]) {
 *             i++;
 *         }
 *
 *         // 最高点不能是数组的第一个位置或最后一个位置
 *         if (i == 0 || i == N - 1) {
 *             return false;
 *         }
 *
 *         // 递减扫描
 *         while (i + 1 < N && A[i] > A[i + 1]) {
 *             i++;
 *         }
 *
 *         return i == N - 1;
 *     }
 * @author 苞谷洁子
 * @ClassName ValidMountainArray
 * @date 2020/11/4 16:08
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        //用于记录上一次是增加还是减少
        //true表示增加，false表示减少
        //增加的前一次记录不允许为减少
        boolean flag = true;
        if(A.length < 3){
            return false;
        }
        if(A[0] >= A[1]){
            return false;
        }
        for (int i = 1; i < A.length-1; i++) {
            if(A[i] == A[i+1]){
                return false;
            }
            if(flag){ //上一次为增加
                if(A[i] > A[i+1]){
                    flag = false; //本次为减少
                }else{
                    flag = true; //本次为增加
                }
            }else{ //上一次为减少，不允许再出现增加
                if(A[i] > A[i+1]){
                    flag = false; //本次为减少
                }else{
                    return false; //本次为增加
                }
            }
        }
        if(A[A.length - 1] >= A[A.length - 2]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
//        int[] A = {0,3,2,1};
        int[] A = {3,3,2,1};
        boolean b = validMountainArray.validMountainArray(A);
        System.out.println(b);
    }
}
