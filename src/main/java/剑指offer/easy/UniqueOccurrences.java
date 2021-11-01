package 剑指offer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO  LeetCode 1207
 * 独一无二的出现次数。对于整数数组arr，统计数组中每个数的出现次数，日过每个数的出现次数都不同，则返回true。
 * 评论中的优秀解答
 * public boolean uniqueOccurrences(int[] arr) {
 *
 *         Map<Integer, Integer> counter = new HashMap<>();
 *         for (int elem : arr)
 *             counter.put(elem, counter.getOrDefault(elem, 0) + 1);
 *
 *         return counter.size() == new HashSet<Integer>(counter.values()).size();
 *     }
 * 上述利用到了Set集合中没有重复元素的特性
 * @author 苞谷洁子
 * @ClassName UniqueOccurrences
 * @date 2020/10/28 11:06
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> intMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<arr.length;i++){
            if(intMap.get(arr[i]) != null){
                intMap.put(arr[i],intMap.get(arr[i])+1);
            }else{
                intMap.put(arr[i],1);
            }
        }
        Object[] values = intMap.values().toArray();
        for (int n = 0;n<values.length;n++){
            for(int m = n+1;m<values.length;m++){
                if (values[n] == values[m]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
        int[] arr = {1,2,2,1,1,3};
        boolean b = uniqueOccurrences.uniqueOccurrences(arr);
        System.out.println(b);
    }
}
