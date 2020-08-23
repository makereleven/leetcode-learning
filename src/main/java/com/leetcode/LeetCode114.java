package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mai.gq
 * @date 2020/8/2
 */
public class LeetCode114 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        preNode(root, treeNodes);
        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
        }
        root.right = null;
        root.left = null;

        for (TreeNode treeNode : treeNodes) {
            System.out.println(treeNode);
            root.right = treeNode;
            root = root.right;
        }
    }

    private static void preNode(TreeNode root, List<TreeNode> treeNodes) {
        treeNodes.add(root);
        if (root.left == null || root.right == null) {
            return;
        }
        preNode(root.left, treeNodes);
        preNode(root.right, treeNodes);
    }

    public static void main(String[] args) {

        int[] we = {1, 2, 5, 3, 4, 0, 6};

    }


}
