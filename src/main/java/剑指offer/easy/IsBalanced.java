package 剑指offer.easy;

import 剑指offer.mediumEntity.TreeNode;

/**
 * TODO
 * leetcode 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @author 苞谷洁子
 * @ClassName IsBalanced
 * @date 2021/10/17 21:59
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int sub = Math.abs(depth(root.left) - depth(root.right));
        if(sub > 1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}
