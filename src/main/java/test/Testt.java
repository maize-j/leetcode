package test;

import 剑指offer.easyEntity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Testt
 * @date 2021/10/15 20:10
 */
public class Testt {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 合并K个升序链表
     * @param lists ListNode类一维数组 lists
     * @return ListNode类
     */
    public ListNode mergeKLists (ListNode[] lists) {
        // write code here
        if(lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode head = new ListNode();
        ListNode addList = head;
        for(int i = 0;i<lists.length;i++){
            addList = mergeTwo(addList,lists[i]);
        }
        return head.next;
    }
    public ListNode mergeTwo(ListNode node1,ListNode node2){
        if(node1 == null || node2 == null){
            return node1 == null ? node2 : node1;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (node1 != null && node2 != null){
            if(node1.val <= node2.val){
                temp.next = node1;
                node1 = node1.next;
            }else{
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        temp.next = (node1 == null ? node2 : node1);
        return head.next;
    }

    public static void main(String[] args) {
        Testt testt = new Testt();
         Scanner sc = new Scanner(System.in);
         List<ListNode> lists = new ArrayList<>();
         String str = sc.next();
         ListNode temp = null;
         ListNode temp1 = null;
         for(int i = 0;i<str.length();i++){
             char c = str.charAt(i);
             if(c == ',' || c == '['){
                 continue;
             }
             if(c == '{'){
                 temp = new ListNode();
                 temp1 = temp;
                 continue;
             }
             if(c == '}'){
                 lists.add(temp.next);
                 continue;
             }
             if(c >= '0' && c <= '9'){
                 ListNode listNode = new ListNode();
                 listNode.val = c - '0';
                 temp1.next = listNode;
                 temp1 = temp1.next;
             }
         }
        ListNode listNode = testt.mergeKLists(lists.toArray(new ListNode[0]));
         StringBuffer sb = new StringBuffer();
        while (listNode != null){
            sb.append(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println(sb);
    }
}
