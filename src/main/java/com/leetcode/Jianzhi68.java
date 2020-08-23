package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author mai.gq
 * @date 2020/8/5
 */
public class Jianzhi68 {
    Map<TreeNode, Integer> map = new HashMap<>();
    TreeNode p;
    TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dps(root);
        if (map.containsKey(p) && map.containsKey(q)) {
            for (TreeNode i : map.keySet()) {
                if (map.get(i) == 2) {
                    return i;
                }
            }
        }
        if (map.containsKey(p)) {
            return q;
        } else {
            return p;
        }

    }

    private void dps(TreeNode root) {
        if (root != null) {
            int curVal = map.getOrDefault(root, 0);
            map.put(root, ++curVal);
            if (root == p) {
                return;
            }
            if (root == q) {
                return;
            }
            dps(root.left);
            dps(root.right);
        }
    }
}
