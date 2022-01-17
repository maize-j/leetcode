package leetcode.hard;

import leetcode.utils.CommonUtil;
import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * leetcode 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * @author 苞谷洁子
 * @ClassName MergeKLists
 * @date 2022/1/17 17:35
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode listNode = lists[0];
        for(int i = 1;i<lists.length;i++){
            ListNode temp = lists[i];
            ListNode listNode1 = mergeTwoLists(listNode, temp);
            listNode = listNode1;
        }
        return listNode;
    }

    public static ListNode mergeTwoLists(ListNode listNode1,ListNode listNode2){
        if(listNode1 == null && listNode2 == null){
            return null;
        }
        if(listNode1 == null){
            return listNode2;
        }
        if(listNode2 == null){
            return listNode1;
        }
        ListNode head = listNode1;
        if(listNode1.val <= listNode2.val){
            listNode1 = listNode1.next;
        }else{
            head = listNode2;
            listNode2 = listNode2.next;
        }
        ListNode result = head;

        while (listNode1 != null || listNode2 != null){
            if(listNode1 == null){
                head.next = listNode2;
                break;
            }
            if(listNode2 == null){
                head.next = listNode1;
                break;
            }
            if(listNode1.val <= listNode2.val){
                head.next = listNode1;
                listNode1 = listNode1.next;
                head = head.next;
            }else{
                head.next = listNode2;
                listNode2 = listNode2.next;
                head = head.next;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = CommonUtil.generateListNode(new int[]{1, 3, 4, 5, 8});
        ListNode listNode1 = CommonUtil.generateListNode(new int[]{2, 9, 10});
        ListNode listNode2 = CommonUtil.generateListNode(new int[]{6, 7, 12, 15});
        ListNode[] lists = new ListNode[]{listNode,listNode1,listNode2};
        ListNode listNode3 = mergeKLists(lists);
        CommonUtil.printListNode(listNode3);
    }
}
