package leetcode.hard;

/**
 * TODO
 * leetcode 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @author 苞谷洁子
 * @ClassName FindMedianSortedArrays
 * @date 2022/1/20 16:52
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1 == null?0:nums1.length;
        int length2 = nums2 == null?0:nums2.length;
        if((length1+length2)%2==0){
            int target = getK(nums1,nums2,(length1+length2)/2 - 1);
            int target1 = getK(nums1,nums2,(length1+length2)/2);
            return (target+target1)/2.0;
        }else{
            return getK(nums1,nums2,(length1+length2)/2);
        }
    }

    public static int getK(int[] nums1,int[] nums2,int k){
        if(nums1 == null || nums1.length == 0){
            return nums2[k];
        }else if(nums2 == null || nums2.length == 0){
            return nums1[k];
        }
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;

        while (true){
            if(index1 >= length1){
                if(k == 0){
                    return nums2[index2];
                }
                index2++;
                k--;
                continue;
            }
            if(index2 >= length2){
                if(k == 0){
                    return nums1[index1];
                }
                index1++;
                k--;
                continue;
            }
            if(nums1[index1]<=nums2[index2]){
                if(k==0){
                    return nums1[index1];
                }
                index1++;
                k--;
            }else{
                if(k==0){
                    return nums2[index2];
                }
                index2++;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0};
//        int[] nums1 = {1,3,5};
        int[] nums2 = {0,0,0};
//        int[] nums2 = {2,4,6};
//        System.out.println(getK(nums1,nums2,5));
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
