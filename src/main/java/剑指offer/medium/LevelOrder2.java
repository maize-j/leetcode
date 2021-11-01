package 剑指offer.medium;

import 剑指offer.mediumEntity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * leetcode 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 打印结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 解题思路：计算二叉树的深度，遍历中当二叉树的深度发生变化，说明层级发生变化（这样需要提供一个根据任意节点计算二叉树深度的算法）
 * 解题思路二：同一级的层次相同，因此list下标相同，递归遍历，left或right时，下标+1
 * 解题思路三：每一层遍历一次，以queue的长度作为计数，第一行加入时只有一个，size为1，第二层再遍历时，queue的长度刚好为这一层元素的个数，第三层遍历时，queue的长度刚好为第三层元素的个数
 * @author 苞谷洁子
 * @ClassName LevelOrder2
 * @date 2021/9/5 15:45
 */
public class LevelOrder2 {
/**============================= 解法二 ==============================*/
/**    public static List<List<Integer>> resultList = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        print(root,0);
        return resultList;
    }

    public static void print(TreeNode treeNode,int index){
        if(treeNode != null){
            //未达到过这一层级
            if(resultList.size()<=index){
                resultList.add(new ArrayList<>());
            }
            resultList.get(index).add(treeNode.val);
            print(treeNode.left,index+1);
            print(treeNode.right,index+1);
        }
    }*/

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (queue.peek() != null){
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                size-- ;
            }
            resultList.add(tempList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(9,treeNode4,treeNode5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(4,treeNode2,treeNode3);
        List<List<Integer>> lists = levelOrder(treeNode1);
        for(List<Integer> intList:lists){
            System.out.println(intList);
        }
    }
}
