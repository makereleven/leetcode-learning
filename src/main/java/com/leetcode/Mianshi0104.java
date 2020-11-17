package com.leetcode;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author mai.gq
 * @date 2020/11/17
 */
public class Mianshi0104 {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }


}
