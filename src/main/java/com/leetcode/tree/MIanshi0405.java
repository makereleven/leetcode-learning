package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author mai.gq
 * @date 2020/11/17
 */
public class MIanshi0405 {
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Boolean L = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        Boolean R = isValidBST(root.right);
        return L && R;
    }
}
