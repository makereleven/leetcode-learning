package com.leetcode;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author mai.gq
 * @date 2020/11/17
 */
public class mianshi0102 {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 != len2) return false;

        int[] count1 = new int[26];//记录s1中各个字符的个数
        int[] count2 = new int[26];////记录s2中各个字符的个数


        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a'] += 1;
            count2[s2.charAt(i) - 'a'] += 1;
        }

        //判断count1和count2是否相等
        return Arrays.toString(count1).equals(Arrays.toString(count2));
    }
}
