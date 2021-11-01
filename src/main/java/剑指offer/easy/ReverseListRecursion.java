package 剑指offer.easy;

import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * 反转链表，递归实现
 * head -> next -> next = head
 * @author 苞谷洁子
 * @ClassName ReverseListRecursion
 * @date 2021/3/30 20:09
 */
public class ReverseListRecursion {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode3 = new ListNode(3,listNode2);
        ListNode listNode4 = new ListNode(4,listNode3);
        ListNode listNode5 = new ListNode(5,listNode4);
        ListNode listNode6 = new ListNode(6,listNode5);
        ListNode listNode7 = new ListNode(7,listNode6);
//        while (listNode7 != null){
//            System.out.println(listNode7.getVal());
//            listNode7 = listNode7.getNext();
//        }
        System.out.println("===============");
        ListNode listNode = reverseList(listNode7);
        while (listNode != null){
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode cur = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return cur;
    }
}
