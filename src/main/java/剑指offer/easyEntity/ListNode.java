package 剑指offer.easyEntity;

import lombok.Data;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ListNode
 * @date 2020/10/28 17:21
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
