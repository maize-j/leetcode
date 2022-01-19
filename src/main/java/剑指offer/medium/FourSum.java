package 剑指offer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *leetcode 18 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * dalao的DFS回溯+剪枝解法
 * @author 苞谷洁子
 * @ClassName FourSum
 * @date 2021/8/30 20:57
 */
public class FourSum {
    static List<List<Integer>> ans = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int cur = 0;
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target,0);
        return ans;
    }
    static void dfs(int[] nums, int target, int begin){
        if(list.size() == 4){
            if(cur == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = begin; i < nums.length; i++ ){
            if(nums.length - i  < 4 - list.size())return;  //nums中数字不够计算了
            if(begin != i && nums[i - 1] == nums[i]) continue;  //存在重复数字
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[i + 1] > target)return; //用后面最小的数计算，如果超过target，说明没有合适的数字，直接返回
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[nums.length - 1] < target)continue;
            cur += nums[i];
            list.add(nums[i]);
            dfs(nums, target, i + 1);
            list.remove(list.size() - 1);
            cur -= nums[i];
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {-5,-4,-3,-2,-1,3,4,5};
//        int target = 0;
        int target = 6;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }

}
