package leetcode.middle;

/**
 * TODO
 * leetcode 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * @author 苞谷洁子
 * @ClassName Rotate
 * @date 2022/1/28 17:19
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1){
            return;
        }
        int length = matrix.length;
        int iLength = (length+1)/2;
        for(int i = 0;i<iLength;i++){
            for(int j = i;j<length-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
                matrix[j][length-i-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] nums = {{1,2,3,4},{5,6,7,8,},{9,10,11,12},{13,14,15,16}};
        for(int[] num:nums){
            for(int i:num){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        System.out.println("======================");
        rotate(nums);
        for(int[] num:nums){
            for(int i:num){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
