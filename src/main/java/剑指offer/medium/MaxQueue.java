package 剑指offer.medium;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * @author 苞谷洁子
 * @ClassName MaxQueue
 * @date 2021/10/20 21:25
 */
public class MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
    Map<Integer,Integer> map = new HashMap<>();

    public MaxQueue() {}

    //队列中的最大值
    public int max_value() {
        if(queue.size() == 0){
            return -1;
        }
        while (!(map.containsKey(pQueue.peek()) && map.get(pQueue.peek()) > 0)){
            pQueue.poll();
        }
        return pQueue.peek();
    }

    //入队
    public void push_back(int value) {
        queue.offer(value);
        pQueue.offer(value);
        if(map.containsKey(value)){
            map.put(value,map.get(value) + 1);
        }else{
            map.put(value,1);
        }
    }

    //出队
    public int pop_front() {
        if(queue.size() == 0){
            return -1;
        }
        int temp = queue.poll();
        map.put(temp,map.get(temp) - 1);
        return temp;
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        System.out.println(obj.max_value());
        obj.push_back(1);
        obj.push_back(2);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }
}
