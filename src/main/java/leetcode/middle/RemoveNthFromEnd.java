package leetcode.middle;

import 剑指offer.easyEntity.ListNode;

import java.util.Scanner;

/**
 * TODO
 * leetcode 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author 苞谷洁子
 * @ClassName RemoveNthFromEnd
 * @date 2021/11/11 20:34
 */
public class RemoveNthFromEnd {
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        while (n > 0){
            //n比链表的长度长
            if(temp == null){
                return null;
            }
            temp = temp.next;
            n--;
        }
        //说明n的长度刚好为链表长度，删除头节点
        if(temp == null){
            return head.next;
        }
        ListNode temp1 = head;
        while (temp.next != null){
            temp1 = temp1.next;
            temp = temp.next;
        }
        temp1.next = temp1.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("\\[|]|,");
        ListNode head = new ListNode();
        ListNode node = head;
        for(int i = 1;i<split.length;i++){
            if("".equals(split[i])){
                continue;
            }
            ListNode temp = new ListNode(Integer.parseInt(split[i]));
            node.next = temp;
            node = node.next;
        }
        int n = sc.nextInt();
        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(head.next, n);
        while (listNode != null){
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
    }

}
