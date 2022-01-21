package leetcode.middle;

/**
 * TODO
 * leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @author 苞谷洁子
 * @ClassName SearchRange
 * @date 2022/1/21 15:59
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        //二分查找
        int start = 0;
        int end = nums.length -1;
        int[] result = new int[]{-1,-1};
        while (start<=end){
            int mid = (start+end)/2;
            if (nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else{
                //分别对mid的左右两边使用二分查找(起点为start，终点为end)，左边找到起点，右边找到终点
                int midStart = start;
                int midEnd = end;
                result[0] = mid;
                result[1] = mid;
                while (midStart <= midEnd){
                    int midMid = (midStart+midEnd)/2;
                    if(nums[midMid]<target){
                        midStart = midMid + 1;
                    }else{
                        if(midMid == start){
                            result[0] = start;
                            break;
                        }
                        if(nums[midMid-1] != target){
                            result[0] = midMid;
                            break;
                        }
                        midEnd = midMid - 1;
                    }
                }
                midStart = mid;
                midEnd = end;
                while (midStart <= midEnd){
                    int midMid = (midStart+midEnd)/2;
                    if(nums[midMid] > target){
                        midEnd = midMid -1;
                    }else{
                        if(midMid == end){
                            result[1] = end;
                            break;
                        }else{
                            if(nums[midMid+1] != target){
                                result[1] = midMid;
                                break;
                            }
                            midStart = midMid+1;
                        }
                    }
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8};
//        int[] nums = {5,5,5,5};
        int target = 8;
//        int target = 5;
        int[] ints = searchRange(nums, target);
        System.out.println(ints[0]+","+ints[1]);
    }
}
