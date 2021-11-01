package 剑指offer.medium;

import java.util.*;

/**
 * TODO
 * leetcode 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 解决方法：全排列问题，用回溯
 * @author 苞谷洁子
 * @ClassName Permutation
 * @date 2021/9/26 21:33
 */
public class Permutation {
//    public static String[] permutation(String s) {
//        if(null == s){
//            return new String[0];
//        }
//        int length = s.;
//        Set<String> strSet = new HashSet<>();
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        for(){
//
//        }
//        String[] strings = strSet.toArray(new String[0]);
//        return strings;
//    }

    public static String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }
    public static void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
    {
        if(s.length() == arr.length)
        {
            list.add(s);
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s+String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        String[] permutation = permutation(str);
        for(String s:permutation){
            System.out.println(s);
        }
    }
}
