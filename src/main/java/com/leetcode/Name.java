package com.leetcode;

import java.util.Arrays;

/**
 * 方法一：Trie + 动态规划
 *
 * @author mai.gq
 * @date 2020/7/27
 */
public class Name {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    public Name() {
    }

    public static void main(String[] args) {
        Name n = new Name();

        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        n.respace(dictionary, sentence);

    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }

}

