package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/8/5
 */
public class Jianzhi15 {
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        hammingWeight(9);
    }
}
