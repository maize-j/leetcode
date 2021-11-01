package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 * leetcode 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 输入：n = 1
 * 输出：["()"]
 * @author 苞谷洁子
 * @ClassName GenerateParenthesis
 * @date 2021/10/27 22:01
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        List<List<String>> lists = new ArrayList<>();
        List<String> strList1 = new ArrayList<String>(){{
            add("");
        }};
        lists.add(strList1);
        List<String> res = new ArrayList<>();
        //记录左括号和右括号使用的数量
        int leftn = 1;
        while (leftn <= n){
            List<String> stringList = lists.get(leftn - 1);
            List<String> stringList1 = new ArrayList<>();
            for(int i = 0;i<stringList.size();i++){
                String s = stringList.get(i);
                int rightn = s.length() - leftn + 1;
                if(leftn-1 < n){
                    s = s + "(";
                    stringList1.add(s);
                }
                while (rightn < leftn){
                    s = s+")";
                    if(leftn == n && rightn == n-1){
                        res.add(s);
                        break;
                    }
                    stringList1.add(s);
                    rightn ++;
                }
            }
            lists.add(stringList1);
            leftn ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        List<String> stringList = generateParenthesis(i);
        for(String str:stringList){
            System.out.print(str + "\t");
        }
    }
}
