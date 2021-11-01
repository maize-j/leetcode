package 剑指offer.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName WordBreak
 * @date 2020/11/1 20:34
 */
public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> stringList = new ArrayList<String>();
        for (String str:wordDict){

        }

        return wordDict;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        List<String> strings = wordBreak.wordBreak("pineapplepenapple", wordDict);
        for (String str:strings){
            System.out.println(str);
        }
    }
}
