package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 * leetcode 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * @author 苞谷洁子
 * @ClassName PermuteUnique
 * @date 2022/1/27 14:59
 */
public class PermuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        dfs(nums,new ArrayList<>(),res,flag);
        return res;
    }

    public static void dfs(int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] flag){
        if(list!=null && list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int index = 0;index<nums.length;index++){
            if(!flag[index] && !(index>0 && nums[index] == nums[index-1] && flag[index-1])){
                list.add(nums[index]);
                flag[index] = true;
                dfs(nums,list,res,flag);
                flag[index] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        List<List<Integer>> lists = permuteUnique(nums);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }

}
