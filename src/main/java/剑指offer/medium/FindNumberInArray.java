package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author 苞谷洁子
 * @ClassName FindNumberIn2DArray
 * @date 2021/8/24 22:01
 */
public class FindNumberInArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ||target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int m = row-1, n = 0;
        //左下角向上查找，target大于当前的数，向右（n+1），target小于当前的数，向上（m-1）
        while (m >= 0 && n < column){
            if(matrix[m][n] == target){
                return true;
            }else if(matrix[m][n] > target){
                m = m-1;
            }else{
                n = n+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{-1,3}};
        boolean numberIn2DArray = findNumberIn2DArray(matrix, 3);
        System.out.println(numberIn2DArray);
    }

}
