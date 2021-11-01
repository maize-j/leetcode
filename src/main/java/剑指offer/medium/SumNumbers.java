package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * 求根到叶子节点数字之和 LeetCode129
 * @author 苞谷洁子
 * @ClassName SumNumbers
 * @date 2020/10/29 8:33
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        queue.add(root);
        numQueue.add(root.val);
        int sum = 0;
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.remove();
            int num = numQueue.remove();
            if(treeNode.left == null && treeNode.right == null){
                sum += num;
            }
            if(treeNode.left != null){
                queue.add(treeNode.left);
                numQueue.add(num * 10 + treeNode.left.val);
            }
            if(treeNode.right != null){
                queue.add(treeNode.right);
                numQueue.add(num * 10 + treeNode.right.val);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(9,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(4,treeNode2,treeNode3);

        int i = sumNumbers.sumNumbers(treeNode1);
        System.out.println("数字总和为："+i);
    }
}
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
