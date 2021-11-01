package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * leetcode 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *        5
 *       / \
 *      4   8
 *     /   / \
 *    11  13  4
 *   /  \    / \
 *  7    2  5   1
 * 返回：
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @author 苞谷洁子
 * @ClassName PathSum
 * @date 2021/9/13 21:37
 */
public class PathSum {

    public static List<List<Integer>> resultList = new ArrayList<>();
    //深度优先搜索，递归
    public static List<List<Integer>> pathSum(TreeNode root, int target) {

        if(root == null){
            return resultList;
        }
        dfs(root,new ArrayList<>(),target,0);
        return resultList;
    }

    public static void dfs(TreeNode root, List<Integer> intList, int target,int sum){
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            if(sum == target){
                intList.add(root.val);
                resultList.add(intList);
            }
            return;
        }
        intList.add(root.val);

        if (root.left != null){
            ArrayList<Integer> integerArrayList = new ArrayList<>(intList);
            dfs(root.left,integerArrayList,target,sum);
        }
        if (root.right != null){
            ArrayList<Integer> integerArrayList = new ArrayList<>(intList);
            dfs(root.right,integerArrayList,target,sum);
        }
    }

    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(7);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(5);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(11,treeNode1,treeNode2);
//        TreeNode treeNode6 = new TreeNode(13);
//        TreeNode treeNode7 = new TreeNode(4,treeNode3,treeNode4);
//        TreeNode treeNode8 = new TreeNode(4,treeNode5,null);
//        TreeNode treeNode9 = new TreeNode(8,treeNode6,treeNode7);
//        TreeNode treeNode = new TreeNode(5,treeNode8,treeNode9);
        TreeNode treeNode1 = new TreeNode(-3);
        TreeNode treeNode2 = new TreeNode(-2,null,treeNode1);
//        List<List<Integer>> lists = pathSum(treeNode, 22);
        List<List<Integer>> lists = pathSum(treeNode2, -5);
        for(List<Integer> intLists:lists){
            System.out.println(intLists);
        }
    }
}
