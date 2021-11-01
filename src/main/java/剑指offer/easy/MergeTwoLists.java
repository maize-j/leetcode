package 剑指offer.easy;

import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * 合并两个有序链表 LeetCode 21
 * @author 苞谷洁子
 * @ClassName MergeTwoLists
 * @date 2020/10/28 17:20
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode listNode = new ListNode();
        if(l1.getVal() > l2.getVal()){
            listNode = l2;
            l2 = l2.getNext();
        }else{
            listNode = l1;
            l1 = l1.getNext();
        }
        //作为头节点，以免找不到返回的节点
        ListNode listNode1 = listNode;
        while (l1 != null && l2 != null){
            if(l1.getVal() > l2.getVal()){
                listNode.setNext(l2);
                l2 = l2.getNext();
            }else{
                listNode.setNext(l1);
                l1 = l1.getNext();
            }
            listNode = listNode.getNext();
        }
        if(l1 != null){
            listNode.setNext(l1);
        }
        if(l2 != null){
            listNode.setNext(l2);
        }
        return listNode1;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode list1node3 = new ListNode(4);
        ListNode list1node2 = new ListNode(2,list1node3);
        ListNode list1node1 = new ListNode(1,list1node2);

        ListNode list2node3 = new ListNode(4);
        ListNode list2node2 = new ListNode(3,list2node3);
        ListNode list2node1 = new ListNode(1,list2node2);
        ListNode listNode = mergeTwoLists.mergeTwoLists(list1node1, list2node1);
        while (listNode != null){
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }
}
