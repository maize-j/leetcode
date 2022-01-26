package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * leetcode 46. 全排列
 * 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author 苞谷洁子
 * @ClassName Permute
 * @date 2022/1/26 22:33
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0){
            return null;
        }
        //动态规划
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        allSort(nums,null,res,flag);

        return res;
    }

    public static void allSort(int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] flag){
        if(list != null && list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i = 0;i<flag.length;i++){
            if(!flag[i]){
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(nums[i]);
                flag[i] = true;
                allSort(nums,list,res,flag);
                //回退
                flag[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        for(List<Integer> list:permute){
            System.out.println(list);
        }
    }
}
