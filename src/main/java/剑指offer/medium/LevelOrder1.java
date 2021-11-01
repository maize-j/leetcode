package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 打印结果：
 * [3,9,20,15,7]
 * @author 苞谷洁子
 * @ClassName LevelOrder
 * @date 2021/9/5 14:51
 */
public class LevelOrder1 {

    public static int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        queue.offer(root);
        while (queue.peek() != null){
            TreeNode tempNode = queue.poll();
            resultList.add(tempNode.val);
            if(tempNode.left != null){
                queue.offer(tempNode.left);
            }

            if(tempNode.right != null){
                queue.offer(tempNode.right);
            }
        }
        int[] resultArray =  resultList.stream().mapToInt(Integer::intValue).toArray();
        return  resultArray;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(9,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(4,treeNode2,treeNode3);
        int[] ints = levelOrder(treeNode1);
        for(int i:ints){
            System.out.print(i + "\t");
        }
    }
}
