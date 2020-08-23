package com.leetcode;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 * <p>
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * @author mai.gq
 * @date 2020/8/10
 */
public class LeetCode696 {
//    public static int countBinarySubstrings(String s) {
//        int n = s.length();
//        int res = 0;
//        for (int i = 2; i <= n; i = i + 2) {
//            int left = 0, right = i - 1;
//            while (right < n ) {
//                if (isTrueSubString(s.substring(left, right + 1))) {
//                    res++;
//                }
//                left++;
//                right++;
//            }
//        }
//        return res;
//    }
//
//    private static boolean isTrueSubString(String s) {
//        int m = s.length();
//        int i = 0, j = m - 1;
//        boolean flag = true;
//        char startChat = s.charAt(0);
//        while (i < j&&flag) {
//            if (s.charAt(i) == s.charAt(j) || s.charAt(i) != startChat) {
//                flag = false;
//            }
//            i++;
//            j--;
//        }
//        return flag;
//    }

    public static int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "00110011";
//        String s = "01";
        countBinarySubstrings(s);
    }
}
