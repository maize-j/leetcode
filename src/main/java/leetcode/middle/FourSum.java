package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TODO
 * leetcode 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 例如：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * @author 苞谷洁子
 * @ClassName FourSum
 * @date 2022/1/18 16:58
 */
public class FourSum {

    private static List<List<Integer>> result = new ArrayList<>();
    private static int targetA;
    private static List<Integer> list = new ArrayList<>();

    //官方增加了用例，会超出int的限制，因此用减法
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        targetA = target;
        dfs(nums,targetA,0);
        return result;
    }

    public static void dfs(int[] nums,int sub,int begin){

        if(list.size() == 4 && sub == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int index = begin;index<nums.length;index++){
            if(nums.length-index < 4-list.size()) return;
            if(begin != index && nums[index-1] == nums[index]) continue;
            //剪枝
            if(index<nums.length-1 && sub-nums[index] < (3-list.size())*(long)nums[index+1]) return;
            if(sub-nums[index] > (3-list.size())*(long)nums[nums.length-1]) continue;
            sub = sub - nums[index];
            list.add(nums[index]);
            dfs(nums,sub,index + 1);
            sub = sub + nums[index];
            list.remove(list.size()-1);
        }

    }


    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums = {2,2,2,2,2};
//        int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
//        int[] nums = {-5,-4,-3,-2,-1,3,4,5};
//        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
//        int target = 0;
//        int target = 6;
//        int target = 8;
//        int target = 1000000000;
        int[] nums = {1,1,2,2,3,3,4,4,5,5};
        int target = 10;
        List<List<Integer>> lists = fourSum(nums, target);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
}
