package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/8/3
 */
public class Jianzhi54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthLargest(TreeNode root, int k) {
        if(root==null) return 0;
        if(k==0) return root.val;
        kthLargest(root.left, --k);
        kthLargest(root.right, --k);
        return 0;
    }

}
