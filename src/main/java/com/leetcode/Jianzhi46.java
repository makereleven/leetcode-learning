package com.leetcode;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @author mai.gq
 * @date 2020/9/27
 */
public class Jianzhi46 {
    private int res = 0;

    public int translateNum(int num) {
        String num1 = String.valueOf(num);
        count(num1);
        return res;
    }

    private void count(String num1) {
        if (num1.equals("")) {
            res++;
            return;
        }
        if (Integer.parseInt(num1.substring(0, 1)) <= 25) {
            count(num1.substring(1));
        }
        if (num1.length() >= 2 && Integer.parseInt(num1.substring(0, 2)) <= 25) {
            if (!num1.startsWith("0")) {

                count(num1.substring(2));
            }
        }
    }

    public void main(String[] args) {
        translateNum(506);
    }
}
