package leetcode.middle;

/**
 * TODO
 * leetcode 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1。
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * @author 苞谷洁子
 * @ClassName Search
 * @date 2022/1/20 18:07
 */
public class Search {

    //要求为O(log n)的解决方案
    //旋转了k个元素
    //和数组第一个数字比较，如果大于第一个数字，则在前半截，否则在后半截
    public static int search(int[] nums, int target) {
        //二分查找
        int index = -1;
        int start = 0,end = nums.length-1;
        boolean flag = nums[0] <= target;
        while (start<=end){
            int mid = nums[(start+end)/2];
            if(mid == target){
                return (start+end)/2;
            }
            if(flag){
                if(mid > target || mid < nums[0]){
                    end = (start+end)/2 -1;
                }else{
                    start = (start+end)/2 + 1;
                }
            }else{
                if(mid < target || mid >= nums[0]){
                    start = (start+end)/2 + 1;
                }else{
                    end = (start+end)/2 -1;
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {3,1};
//        int target = 0;
        int target = 1;
        int search = search(nums, target);
        System.out.println(search);
    }

}
