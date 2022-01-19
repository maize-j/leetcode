package leetcode.hard;

import leetcode.utils.CommonUtil;
import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * leetcode 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 * SwapPairs的升级版本，SwapPairs是两个元素翻转
 * @author 苞谷洁子
 * @ClassName ReverseKGroup
 * @date 2022/1/19 21:54
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }
        //翻转前k个，并返回翻转后的节点，不足k个直接返回
        //先判断节点是否够翻转
        ListNode temp = head;
        int n = k;
        while (temp != null && n > 0){
            n--;
            temp = temp.next;
        }
        //长度不够
        if(n > 0){
            return head;
        }

        ListNode pre = head;
        if(pre == null || pre.next == null){
            return pre;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        pre.next = null;
        //当有k个数时，需要翻转的next指针为k-1个，其中一个在循环外处理，因此是k-2
        for(int i = 0;i<k-2;i++){
            if(next == null){
                break;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;

        head.next = reverseKGroup(next,k);

        return cur;

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ListNode listNode = CommonUtil.generateListNode(nums);
//        ListNode listNode = null;
        int k = 2;
        ListNode listNode1 = reverseKGroup(listNode, k);
        CommonUtil.printListNode(listNode1);
    }
}
