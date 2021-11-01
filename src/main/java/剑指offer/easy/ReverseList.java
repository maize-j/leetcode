package 剑指offer.easy;

import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * 反转链表
 * @author 苞谷洁子
 * @ClassName ReverseList
 * @date 2021/3/30 19:35
 */
public class ReverseList {
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
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode listNode = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = listNode;
        }
        return pre;
    }

}
