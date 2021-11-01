package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 打印结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author 苞谷洁子
 * @ClassName LevelOrder
 * @date 2021/9/5 16:35
 */
public class LevelOrder3 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.add(root);
        }
        //为true时从左向右，false时从右向左
        Boolean flag = true;
        while (!stack.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int size = stack.size();
            Stack<TreeNode> tempStack = new Stack<>();
            while (size > 0){
                TreeNode tempNode = stack.pop();
                tempList.add(tempNode.val);
                if(flag){
                    if(tempNode.left != null){
                        tempStack.add(tempNode.left);
                    }
                    if(tempNode.right != null){
                        tempStack.add(tempNode.right);
                    }
                }else{
                    if(tempNode.right != null){
                        tempStack.add(tempNode.right);
                    }
                    if(tempNode.left != null){
                        tempStack.add(tempNode.left);
                    }
                }
                size-- ;
            }
            stack.addAll(tempStack);
            flag = !flag;
            resultList.add(tempList);
        }
        return resultList;
    }

    public static void main(String[] args) {
//        TreeNode treeNode4 = new TreeNode(5);
//        TreeNode treeNode5 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(9,treeNode4,treeNode5);
//        TreeNode treeNode3 = new TreeNode(0);
//        TreeNode treeNode1 = new TreeNode(4,treeNode2,treeNode3);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(20,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode1 = new TreeNode(4,treeNode3,treeNode2);


        List<List<Integer>> lists = levelOrder(treeNode1);
        for(List<Integer> intList:lists){
            System.out.println(intList);
        }
    }
}
