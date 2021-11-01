package 剑指offer.hard;

import 剑指offer.mediumEntity.TreeNode;

import java.util.*;

/**
 * TODO
 * LeetCode 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 输入输出格式类似于leetcode中的格式 [1,2,3,null,null,4,5]
 * @author 苞谷洁子
 * @ClassName Codec
 * @date 2021/9/21 20:18
 */
public class Codec {

    // Encodes a tree to a single string.
    //层次遍历？
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuffer serialize = new StringBuffer("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            TreeNode poll = queue.poll();
            if(poll != null){
                serialize.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }else{
                serialize.append("null,");
            }
        }
        return serialize.toString();
    }

    // Decodes your encoded data to tree.
    //层次遍历解码
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] strs = data.split(",");
        if(strs == null || strs.length == 0 || "".equals(strs[0])){
            return null;
        }
        int size = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //从根节点的下一个节点开始
        int index = 1;
        while (queue.size() > 0 && index < size){
            TreeNode poll = queue.poll();
            if(!"null".equals(strs[index])){
                poll.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(poll.left);
            }
            index ++ ;
            if(!"null".equals(strs[index])){
                poll.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(poll.right);
            }
            index ++ ;
        }
        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
//        String data = "1,2,3,null,5,6,7,8,9,null,null,10,11";
        String data = "";
        TreeNode deserialize = codec.deserialize(data);
        System.out.println(deserialize);
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
        TreeNode deserialize1 = codec.deserialize(serialize);
        System.out.println(deserialize1);
    }
}
