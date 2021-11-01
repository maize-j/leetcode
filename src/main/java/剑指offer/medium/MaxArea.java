package 剑指offer.medium;

/**
 * TODO
 * leetCode 11 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：不能倾斜容器
 * @author 苞谷洁子
 * @ClassName MaxArea
 * @date 2021/8/25 22:13
 */
public class MaxArea {
    /***
     *@author 苞谷洁子
     * @param height 数组
     *@return 形成的最大容量
     *@throws
     *@date  
     */
    public static int maxArea(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int max = 0;
        int start = 0,end = height.length-1;
        while (start <= end){
            int temp = Math.min(height[start],height[end]) * (end - start);
            max = Math.max(max,temp);
            //较小的指针移动
            if(height[start] > height[end]){
                end --;
            }else{
                start ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }

}
