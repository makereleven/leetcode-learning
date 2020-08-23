package com.leetcode;

import java.util.*;

/**
 * @author mai.gq
 * @date 2020/7/27
 */
public class DFSZM {
    List<String> wordList;
    boolean[] marked;
    List<String> output;
    String endWord;
    List<String> result;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList=wordList;
        output=new ArrayList();
        marked=new boolean[wordList.size()];
        result=new ArrayList();
        this.endWord=endWord;
        dfs(beginWord);
        return result;
    }

    public void dfs(String s){
        output.add(s);
        Queue<String> queue=oneCharDiff(s);
        for(String str:queue){
            if(str.equals(endWord)) {
                output.add(str);
                result=new ArrayList(output);
                return;
            }
            dfs(str);
            output.remove(output.size()-1);
        }

    }
    public Queue<String> oneCharDiff(String s){
        Queue<String> queue=new LinkedList();
        for(int j=0;j<wordList.size();j++){
            String str=wordList.get(j);
            int diffNum=0;
            if(str.length()!=s.length() || marked[j]) continue;
            for(int i=0;i<str.length();i++){
                if(diffNum>=2) break;
                if(str.charAt(i)!=s.charAt(i)) diffNum++;
            }
            if(diffNum==1) {
                queue.add(str);
                marked[j]=true;
            }
        }
        return queue;
    }

    public DFSZM() {
    }

    public static void main(String[] args) {
        DFSZM d = new DFSZM();
        String[] s = {"hot", "dot", "dog", "lot", "log", "cog"};
        d.findLadders("hit", "cog", Arrays.asList(s));
    }
}
