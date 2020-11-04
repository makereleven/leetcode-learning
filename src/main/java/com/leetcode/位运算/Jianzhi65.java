package com.leetcode.位运算;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author mai.gq
 * @date 2020/11/4
 */
public class Jianzhi65 {
    public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;

    }
}
