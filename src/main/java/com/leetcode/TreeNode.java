package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/16
 */
public class TreeNode {
    public  int val;
    public  TreeNode left;
    public  TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
