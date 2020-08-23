package com.leetcode.BFS;


import com.leetcode.TreeNode;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * @author mai.gq
 * @date 2020/8/7
 */
public class Jianzhi32 {
    int [] res = new int[1000];
    int i = 0;
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        res[i++] = root.val;
        levelOrder(root.left);
        levelOrder(root.right);
        return res;
    }
}
