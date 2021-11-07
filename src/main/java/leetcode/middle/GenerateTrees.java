package leetcode.middle;

import 剑指offer.mediumEntity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 * leetcode 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * @author 苞谷洁子
 * @ClassName GenerateTrees
 * @date 2021/11/7 20:55
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = generateTree(1, n);
        return treeNodes;
    }

    //分解子问题：一整棵树为二叉搜索树，说明左右子树也分别为二叉搜索树
    //在start和end中间找根节点i，start~i-1为左子树，i+1~end为右子树
    public List<TreeNode> generateTree(int start,int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            //避免在循环的时候，由于是空数组，直接不进入循环内部，跳出了
            list.add(null);
            return list;
        }
        for(int i = start;i<=end;i++){
            //左子树的组合的结果，可能有多种，挑出其中的一种
            List<TreeNode> left = generateTree(start,i-1);
            //右子树的组合的结果，可能有多种，挑出其中的一种
            List<TreeNode> right = generateTree(i+1,end);
            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode treeNode = new TreeNode(i,leftNode,rightNode);
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(new GenerateTrees().generateTrees(i));
//        List<TreeNode> list = new ArrayList<>();
//        for(TreeNode n:list){
//            for(int i = 0;i<5;i++){
//                System.out.print(i+"\t");
//            }
//        }
//        System.out.println();
//        list.add(null);
//        for(TreeNode n:list){
//            for(int i = 0;i<5;i++){
//                System.out.print(i+"\t");
//            }
//        }
    }
}
