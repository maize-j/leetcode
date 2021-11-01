package 剑指offer.easy;

import 剑指offer.mediumEntity.TreeNode;

import java.util.Stack;

/**
 * TODO
 * leetcode 剑指 Offer 54. 二叉搜索树的第k大节点
 * @author 苞谷洁子
 * @ClassName KthLargest
 * @date 2021/10/17 21:11
 */
public class KthLargest {
    Stack<Integer> stack;
    //中序遍历
    public int kthLargest(TreeNode root, int k) {
        stack = new Stack<>();
        midSearch(root,k);
        while (k > 1){
            stack.pop();
            k--;
        }
        return stack.pop();
    }

    public void midSearch(TreeNode root,int k){
        if(root.left != null){
            midSearch(root.left,k);
        }
        stack.add(root.val);
        if(root.right != null){
            midSearch(root.right,k);
        }
    }
    /*也可以使用中序遍历的逆向遍历，右->中->左，在遍历中计数，n==k时，返回元素（提前结束），结果和k用全局变量存储*/
    public static void main(String[] args) {

    }
}
