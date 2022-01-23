package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 * leetcode 40. 组合总和 II
 * 给你一个由候选元素组成的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个元素在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。 
 * 例如：
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 例如：
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * @author 苞谷洁子
 * @ClassName CombinationSum2
 * @date 2022/1/23 23:24
 */
public class CombinationSum2 {

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int target;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }
        CombinationSum2.target = target;
        Arrays.sort(candidates);
        dfs(candidates,0,0);
        return result;
    }

    public static void dfs(int[] nums,int sum,int start){
        if(sum == target){
//            if(result.size() == 0){
                result.add(new ArrayList<>(list));
                return;
//            }
//            List<Integer> temp = result.get(result.size() -1);
//            if(temp.size() != list.size()){
//                result.add(new ArrayList<>(list));
//                return;
//            }
//            for(int i = 0;i<list.size();i++){
//                if(temp.get(i) != list.get(i)){
//                    result.add(new ArrayList<>(list));
//                    return;
//                }
//            }
//            return;
        }
        for(int index = start; index<nums.length; index++){
            //剪枝
            if(sum + nums[index] > target) return;
            //去除重复元素
            if(index != start && nums[index] == nums[index-1]) continue;

            sum += nums[index];
            list.add(nums[index]);
            dfs(nums,sum,index+1);
            sum -= nums[index];
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {10,1,2,7,6,1,5};
//        int target = 8;
//        int[] nums = {2,5,2,1,2};
//        int target = 5;
        int[] nums = {3,1,3,5,1,1};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(nums, target);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
}
