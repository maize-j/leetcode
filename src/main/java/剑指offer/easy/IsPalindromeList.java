package 剑指offer.easy;

import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * 回文链表
 * @author 苞谷洁子
 * @ClassName IsPalindromeList
 * @date 2021/3/30 20:18
 */
public class IsPalindromeList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2,listNode1);
        ListNode listNode3 = new ListNode(3,listNode2);
        ListNode listNode4 = new ListNode(4,listNode3);
        ListNode listNode5 = new ListNode(3,listNode4);
        ListNode listNode6 = new ListNode(2,listNode5);
        ListNode listNode7 = new ListNode(1,listNode6);
//        ListNode listNode8 = new ListNode(8,listNode7);
//        while (listNode7 != null){
//            System.out.println(listNode7.getVal());
//            listNode7 = listNode7.getNext();
//        }
        System.out.println("===============");
        boolean palindrome = isPalindrome(listNode7);
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.getNext() == null){
            return true;
        }
        int num = 0;
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null){
            quick = quick.getNext();
            num ++;
            if(num%2 != 0){
                continue;
            }
            slow = slow.getNext();
        }
        ListNode listNode;
        if(num%2 == 0){
            listNode = reverseList(slow);
        }else{
            listNode = reverseList(slow.getNext());
        }
        while (listNode != null){
            if(listNode.getVal() != head.getVal()){
                return false;
            }
            listNode = listNode.getNext();
            head = head.getNext();
        }
        return true;
    }

    public static ListNode reverseList(ListNode head){
        if(head.getNext() == null || head == null){
            return head;
        }
        ListNode cur = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return cur;
    }
}
