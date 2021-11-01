package 剑指offer.medium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *leetcode 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @author 苞谷洁子
 * @ClassName TreeToDoublyList
 * @date 2021/9/16 22:03
 */
public class TreeToDoublyList {
    public static Queue<Node> nodeQueue = new LinkedList<>();
    public static void main(String[] args) {
        treeToDoublyList(null);
    }

    //中序遍历
    public static Node treeToDoublyList(Node root) {

        if(root == null){
            return null;
        }
        midSeq(root);
        Node head = nodeQueue.peek();
        while (nodeQueue.peek() != null) {
            Node tempNode = nodeQueue.poll();
            if(nodeQueue.peek() != null){
                Node nextNode = nodeQueue.peek();
                tempNode.right = nextNode;
                nextNode.left = tempNode;
            }else{
                tempNode.right = head;
                head.left = tempNode;
            }
        }
        return head;
    }
    public static void midSeq(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            midSeq(root.left);
        }
        nodeQueue.add(root);
        if(root.right != null){
            midSeq(root.right);
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}

