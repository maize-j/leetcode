package 剑指offer.easy;

/**
 * TODO
 * 搜索插入位置 LeetCode35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * LeetCode中的解法是使用二分查找的方式
 * @author 苞谷洁子
 * @ClassName SearchInsert
 * @date 2020/10/29 19:50
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums[0] >= target){
            return 0;
        }
        int i = 0;
        for(;i<nums.length-1;i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[i]<target && nums[i+1]>target){
                return i+1;
            }
        }
        if(nums[i] == target){
            return i;
        }else{
            return i+1;
        }
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = {1,3,5,6};
//        int target = 5;
        int target = 0;
        int i = searchInsert.searchInsert(nums, target);
        System.out.println("目标位置："+i);
    }
}
