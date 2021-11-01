package 剑指offer.mediumEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Node
 * @date 2021/9/15 22:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node(int val){
        this.val = val;
    }
    public Node(int val,Node node,String type){
        this.val = val;
        if(type.equals("random")){
            this.random = node;
        }else{
            this.next = node;
        }

    }
}
