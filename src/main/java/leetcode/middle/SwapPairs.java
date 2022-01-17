package leetcode.middle;

import leetcode.utils.CommonUtil;
import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * leetcode  24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = []
 * 输出：[]
 *
 * 输入：head = [1]
 * 输出：[1]
 * @author 苞谷洁子
 * @ClassName SwapPairs
 * @date 2022/1/16 22:26
 */
public class SwapPairs {

    /**官方解法*/
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

//    public static ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode first = head;
//        ListNode second = head.next;
//        ListNode resultHead = second;
//        ListNode third = second.next;
//
//        while(first != null){
//            if(third != null){
//                if(third.next != null){
//                    first.next = third.next;
//                    second.next = first;
//                    first = third;
//                    second = first.next;
//                    third = second.next;
//                }else{
//                    first.next = third;
//                    second.next = first;
//                    break;
//                }
//            }else{
//                second.next = first;
//                first.next = null;
//                break;
//            }
//        }
//        return resultHead;
//    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode listNode1 = CommonUtil.generateListNode(nums);
        ListNode listNode = swapPairs(listNode1);
        CommonUtil.printListNode(listNode);
    }
}
