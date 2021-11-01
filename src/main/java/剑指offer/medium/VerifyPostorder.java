package 剑指offer.medium;

/**
 * TODO
 *leetcode 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * @author 苞谷洁子
 * @ClassName VerifyPostorder
 * @date 2021/9/6 21:29
 */
public class VerifyPostorder {

    /**
     *二叉搜索树的特性:左子树<根<右子树
     * 后续遍历，最后一个结点肯定为根节点
     * 从第一个大于根节点的节点开始，到根节点均为右子树，从第一个节点到第一个大于根节点的节点为左子树，再依次判断左右子树是否符合条件
     */
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder== null || postorder.length <=2){
            return true;
        }
        boolean legel = isLegel(postorder, 0, postorder.length - 1);
        return legel;
    }

    public static boolean isLegel(int[] postorder,int start,int end){
        int temp = postorder[end];
        int index = start;
        while (index < end && postorder[index] < temp){
            index ++;
        }
        //找到第一位大于根节点的数字后，说明为右子树，右边的必须全部大于根节点
        int tempIndex = index;
        while (tempIndex < end){
            if(postorder[tempIndex] < temp){
                return false;
            }
            tempIndex++;
        }
        boolean pre = true;
        if(index>start){
            pre = isLegel(postorder,start,index-1);
        }
        boolean last = true;
        if(index < end){
            last = isLegel(postorder,index, end-1);
        }
        boolean result = pre && last;
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,2,6,5};
        int[] nums = {1,6,3,2,5};
        boolean b = verifyPostorder(nums);
        System.out.println(b);
    }
}
