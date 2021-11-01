package 剑指offer.easy;

import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 * leetcode 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * @author 苞谷洁子
 * @ClassName GetIntersectionNode
 * @date 2021/10/16 20:05
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int aLength = 0;
        int bLength = 0;
        while (a != null){
            aLength ++;
            a = a.next;
        }
        while (b != null){
            bLength ++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if(aLength > bLength){
            while (aLength != bLength){
                a = a.next;
                aLength--;
            }
        }else if(aLength < bLength){
            while (aLength != bLength){
                b = b.next;
                bLength--;
            }
        }
        while (a != null && b != null){
            if(a == b){
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }


    //官方解答，民间理解：两个速度一样的人再不同长度的跑道，如何让其相遇？交换跑到，A跑完A的跑道去B的起点，B跑完B的跑道去A的起点，必定会有交界点
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
//    }
}
