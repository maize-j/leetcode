package leetcode.middle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 * leetcode 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。\
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 例如：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 例如：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * @author 苞谷洁子
 * @ClassName CombinationSum
 * @date 2022/1/23 19:44
 */
public class CombinationSum {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int target;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }
        CombinationSum.target = target;
        Arrays.sort(candidates);
        dfs(candidates,0,0);
        return result;
    }

    //数组无重复元素，不用去重
    public static void dfs(int[] nums,int sum, int index){

        if(sum == target){
            //sum与target值相等时，将list加入最终的结果中
            result.add(new ArrayList<>(list));
            return;
        }

        for(;index<nums.length;index++){
            //sum加上当前的值大于0时，直接返回
            if(sum + nums[index] > target) return;
            sum += nums[index];
            list.add(nums[index]);
            dfs(nums,sum,index);
            sum = sum - nums[index];
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
//        int[] nums = {2,3,6,7};
//        int target = 7;
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(nums, target);
        for(List<Integer> list:lists){
            for(int i:list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
