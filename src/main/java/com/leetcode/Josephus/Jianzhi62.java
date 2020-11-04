package com.leetcode.Josephus;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @author mai.gq
 * @date 2020/11/2
 */
public class Jianzhi62 {
    /*****递归*****/
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    /*****递归*****/


//    int ans = 0;
//    // 最后一轮剩下2个人，所以从2开始反推
//        for (int i = 2; i <= n; i++) {
//        ans = (ans + m) % i;
//    }
//        return ans;
    public static void main(String[] args) {
        Jianzhi62 jianzhi62 = new Jianzhi62();
        jianzhi62.lastRemaining(5, 2);
    }
}
