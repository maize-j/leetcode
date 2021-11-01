package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

/**
 * TODO
 * 求根到叶子节点数字之和 LeetCode129
 * LeetCode中的dalao解答
 * @author 苞谷洁子
 * @ClassName SumNumbers1
 * @date 2020/10/29 19:32
 */
public class SumNumbers1 {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root, int i){
        if(root == null) return 0;
        int temp = i*10 + root.val;
        if(root.left == null && root.right == null){
            return temp;
        }
        return helper(root.left,temp) + helper(root.right,temp);
    }
}
