package 剑指offer.easy;

import 剑指offer.mediumEntity.TreeNode;

import java.util.*;

/**
 * TODO
 *leetcode 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * @author 苞谷洁子
 * @ClassName LowestCommonAncestor2
 * @date 2021/10/26 22:37
 */
public class LowestCommonAncestor2 {
    //深度优先搜索，比较路径
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p==null || q==null){
            return null;
        }
        List<TreeNode> pPath = new ArrayList<>(getPath(root,p,new Stack<>()));
        List<TreeNode> qPath = new ArrayList<>(getPath(root,q,new Stack<>()));
        int min = Math.min(pPath.size(),qPath.size());
        int index = 0;
        for(int i = 0;i<pPath.size();i++){
            System.out.print(pPath.get(i).val + "\t");
        }
        System.out.println();
        for(int i = 0;i<qPath.size();i++){
            System.out.print(qPath.get(i).val + "\t");
        }
        while (index < min && pPath.get(index) == qPath.get(index)){
            index ++;
        }
        if(index == min-1 && pPath.get(index) == qPath.get(index)){
            return pPath.get(index);
        }
        return pPath.get(index-1);
    }

    public Stack<TreeNode> getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack){
        if(root == null){
            return null;
        }
        if(root == node){
            stack.add(root);
            return stack;
        }
        Stack<TreeNode> res = new Stack<>();
        res.add(root);
        Stack<TreeNode> leftStack = getPath(root.left,node,stack);
        if(leftStack != null){
            res.addAll(leftStack);
            return res;
        }
        Stack<TreeNode> rightStack = getPath(root.right,node,stack);
        if(rightStack != null){
            res.addAll(rightStack);
            return res;
        }
        return null;
    }
//    评论区优秀解答
//    l、r 非空时，说明 p、q 分居 root 的两侧，root 就是 LCA
//    l、r 任一为空，说明 LCA 位于另一子树或其祖先中
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || p == root || q == root) {
//            return root;
//        }
//
//        TreeNode l = lowestCommonAncestor(root.left, p, q);
//        TreeNode r = lowestCommonAncestor(root.right, p, q);
//
//        return l == null ? r : (r == null ? l : root);
//    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(9);
        treeNode1.left = treeNode;
        TreeNode treeNode2 = new TreeNode(8);
        treeNode2.left = treeNode1;
        TreeNode treeNode3 = new TreeNode(7);
        treeNode3.left = treeNode2;
        TreeNode treeNode4 = new TreeNode(6);
        treeNode4.left = treeNode3;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode5.left = treeNode4;
        TreeNode treeNode6 = new TreeNode(4);
        treeNode6.left = treeNode5;
        TreeNode treeNode7 = new TreeNode(3);
        treeNode7.left = treeNode6;
        TreeNode treeNode8 = new TreeNode(2);
        treeNode8.left = treeNode7;
        TreeNode treeNode9 = new TreeNode(1);
        treeNode9.left = treeNode8;
        System.out.println(new LowestCommonAncestor2().lowestCommonAncestor(treeNode9, treeNode1, treeNode));

    }
}
