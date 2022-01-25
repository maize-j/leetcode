package leetcode.hard;

/**
 * TODO
 * leetcode 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * @author 苞谷洁子
 * @ClassName Trap
 * @date 2022/1/25 14:32
 */
public class Trap {

    //官方双指针解法
    public static int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int length = height.length;
        int sum = 0;
        int start  = 0;
        int end = length-1;
        int startMax = 0, endMax = 0;
        while (start < end){
            startMax = Math.max(startMax,height[start]);
            endMax = Math.max(endMax,height[end]);
            if(height[start] < height[end]){
                sum += startMax - height[start];
                start ++;
            }else{
                sum += endMax - height[end];
                end--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(nums);
        System.out.println(trap);
    }
}
