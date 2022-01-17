package leetcode.utils;

import test.Solution;
import 剑指offer.easyEntity.ListNode;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName CommonUtil
 * @date 2022/1/16 22:36
 */
public class CommonUtil {
    public static ListNode generateListNode(int[] nums){
        int n = nums.length;
        ListNode node = new ListNode(nums[n-1]);
        for(int i = n-2;i>=0;i--){
            ListNode listNode = new ListNode(nums[i], node);
            node = listNode;
        }
        return node;
    }

    public static void printListNode(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode listNode = generateListNode(nums);
        printListNode(listNode);
        System.out.println(listNode);
    }
}
