package com.leetcode;


import java.util.HashMap;

/**
 * 重建二叉树
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author mai.gq
 * @date 2020/7/16
 */


public class ReBuildTree {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, 0, inorder.length - 1);
    }

    /**
     * 构建树
     *
     * @param pre_root 前序数组根结点下标
     * @param in_left  左边界
     * @param in_right 右边界
     * @return
     */
    private TreeNode buildTree(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(po[pre_root]);
        int i = map.get(po[pre_root]);
        root.left = buildTree(pre_root + 1, in_left, i-1);
        /**
         * 构建右子树
         * pre_root+(i - in_left)+1  =  根节点索引 + 左子树长度 + 1
         */
        root.right = buildTree(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }


}
