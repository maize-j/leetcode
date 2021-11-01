package 剑指offer.easy;

/**
 * TODO
 * 删除排序数组中的重复项 LeetCode26
 * 在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * 你必须在原地修改输入数组 并在使用O(1)额外空间的条件下完成
 * @author 苞谷洁子
 * @ClassName RemoveDuplicates
 * @date 2020/10/28 20:39
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates.removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}
