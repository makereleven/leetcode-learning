package com.leetcode.分治;

/**
 * @author mai.gq
 * @date 2021/1/29
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] num = new int[n + m + 1];
        int l = 0, r = 0, c = 0;
        while (l < n && r < m) {
            if (nums1[l] > nums2[r]) {
                num[c] = nums1[r];
                r++;
            } else {
                num[c] = nums2[l];
                l++;
            }
            c++;

        }
        if (l < n) {
            for (int i = l; i < n; i++) {
                num[c] = nums1[l];
            }
        }
        if (l < m) {
            for (int i = r; i < m; i++) {
                num[c] = nums2[r];
            }
        }
        if (c % 2 == 0) {
            return (num[c / 2 - 1] + num[c / 2]) / 2.0;
        } else {
            return num[c / 2];
        }

    }
}
