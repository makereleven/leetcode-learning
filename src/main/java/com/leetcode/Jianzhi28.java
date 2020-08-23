package com.leetcode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author mai.gq
 * @date 2020/8/6
 */
public class Jianzhi28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
