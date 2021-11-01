package 剑指offer.easy;

import 剑指offer.mediumEntity.TreeNode;

/**
 * TODO
 * leetcode 剑指 Offer 55 - I. 二叉树的深度
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 * @author 苞谷洁子
 * @ClassName MaxDepth
 * @date 2021/10/17 21:51
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {

        return depth(root,0);
    }
    public int depth(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.max(depth(root.left,depth + 1), depth(root.right,depth +1));
    }
}
