package 剑指offer.easy;

/**
 * TODO
 * 移除元素 LeetCode 27
 * 给定数组nums和一个值val，你需要原地移除所有数值等于val的元素，返回移除后数组的新长度
 * 不使用额外的数组空间，只使用O(1)的额外空间
 * @author 苞谷洁子
 * @ClassName RemoveElement
 * @date 2020/10/28 21:23
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j =0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int num = 2;
        int i = removeElement.removeElement(nums, num);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}
