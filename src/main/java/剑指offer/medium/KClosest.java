package 剑指offer.medium;

/**
 * TODO
 * 最接近原点的 K 个点LeetCode 973
 * 实现方式一：大根堆
 * LeetCode中的大根堆的解法
 * class Solution {
 *     public int[][] kClosest(int[][] points, int K) {
 *         PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
 *             public int compare(int[] array1, int[] array2) {
 *                 return array2[0] - array1[0];
 *             }
 *         });
 *         for (int i = 0; i < K; ++i) {
 *             pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
 *         }
 *         int n = points.length;
 *         for (int i = K; i < n; ++i) {
 *             int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
 *             if (dist < pq.peek()[0]) {
 *                 pq.poll();
 *                 pq.offer(new int[]{dist, i});
 *             }
 *         }
 *         int[][] ans = new int[K][2];
 *         for (int i = 0; i < K; ++i) {
 *             ans[i] = points[pq.poll()[1]];
 *         }
 *         return ans;
 *     }
 * }
 *
 * 实现方式二：快速排序
 * @author 苞谷洁子
 * @ClassName KClosest
 * @date 2020/11/9 12:13
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int[][] close = new int[K][2];
        quickSort(points,0,points.length-1);

        for (int i = 0;i<K;i++){
            close[i][0] = points[i][0];
            close[i][1] = points[i][1];
        }
        return close;
    }

    //start排序起始位置，end排序终止位置(start和end均为下标位置)
    public int[][] quickSort(int[][] points,int start,int end){
        if(points == null || points.length <= 1){
            return points;
        }
        int partition = partition(points,start,end);
        System.out.println("partition:"+partition);
        if(partition > start){
            quickSort(points,start,partition-1);
        }
        if(partition < end){
            quickSort(points,partition+1,end);
        }
        return points;
    }

    //start为分区的开始，end为分区的结束
    //以最后一个点作为分区的点
    public int partition(int[][] points,int start,int end){
        int[] point = points[end];
        double pointSqrt = Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2));
        int k = start;
        for(int i = start;i<end;i++){
            if(Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2)) < pointSqrt){
                int[] temp = points[i];
                points[i] = points[k];
                points[k] = temp;
                k++;
            }
        }
        int[] temp = points[end];
        points[end] = points[k];
        points[k] = temp;

        return k;
    }

    public static void main(String[] args) {
        KClosest kClosest = new KClosest();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] ints = kClosest.kClosest(points, k);
        for(int i = 0;i<ints.length;i++){
            for(int j = 0;j<ints[i].length;j++){
                System.out.print(ints[i][j]+"\t");
            }
            System.out.println("\n*********");
        }
    }
}
