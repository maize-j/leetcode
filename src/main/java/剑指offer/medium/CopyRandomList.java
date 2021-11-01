package 剑指offer.medium;

import 剑指offer.mediumEntity.Node;

/**
 * TODO
 *leetcode 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * @author 苞谷洁子
 * @ClassName CopyRandomList
 * @date 2021/9/15 22:08
 */
public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node node = head;
        while (node != null){
            Node tempNode = new Node(node.val);
            tempNode.next = node.next;
            node.next = tempNode;
            node = node.next.next;
        }
        node = head;
        while (node != null){
//            Node newNode = node.next;
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        Node resultNode = head.next;
        node = head;
        while (node.next != null) {
            Node tempNode = node.next;
            node.next = tempNode.next;
            node = tempNode;
        }
        return resultNode;
    }
    public static void main(String[] args) {

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node2.setRandom(node1);
        node3.setNext(node4);
        node3.setRandom(node5);
        node4.setNext(node5);
        node4.setRandom(node3);
        node5.setRandom(node1);
        Node node = copyRandomList(node1);
        while (node != null){
            System.out.println(node.val + "," + (node.next != null?node.next.val:"null") + "," + (node.random != null?node.random.val : "null"));
            node = node.next;
        }
    }
}
