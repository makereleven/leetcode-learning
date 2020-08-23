package com.leetcode;

/**
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 * <p>
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：A = "abac", B = "baca"
 * 输出：2
 *
 * @author mai.gq
 * @date 2020/7/31
 */
public class LeetCode854 {
    public static int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int count = 0;
        for (int i = 0; i < a.length;) {
            for (int j = i+1; j < a.length; ++j) {
                if (a[i] == b[j]) {
                    if (i != j) {
                        System.out.println(""+a[i] + a[j]);
                        count++;
                        char temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        if (a[i] == b[i]) {
                            i++;
                        }
                    }else {
                        i++;
                    }
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String A = "abac";
//        String B = "baca";
        String A = "abc";
        String B = "bca";
        kSimilarity(A, B);

    }
}
