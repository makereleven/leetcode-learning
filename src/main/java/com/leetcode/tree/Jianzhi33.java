package com.leetcode.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * <p>
 * <p>
 * 总结
 * 方法一：递归分治
 * 根据二叉搜索树的定义，可以通过递归，判断所有子树的 正确性 （即其后序遍历是否满足二叉搜索树的定义） ，若所有子树都正确，则此序列为二叉搜索树的后序遍历。
 * 递归解析：
 * 终止条件： 当 i \geq ji≥j ，说明此子树节点数量 \leq 1≤1 ，无需判别正确性，因此直接返回 truetrue ；
 * 递推工作：
 * 划分左右子树： 遍历后序遍历的 [i, j][i,j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 mm 。此时，可划分出左子树区间 [i,m-1][i,m−1] 、右子树区间 [m, j - 1][m,j−1] 、根节点索引 jj 。
 * 判断是否为二叉搜索树：
 * 左子树区间 [i, m - 1][i,m−1] 内的所有节点都应 << postorder[j]postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
 * 右子树区间 [m, j-1][m,j−1] 内的所有节点都应 >> postorder[j]postorder[j] 。实现方式为遍历，当遇到 \leq postorder[j]≤postorder[j] 的节点则跳出；则可通过 p = jp=j 判断是否为二叉搜索树。
 * 返回值： 所有子树都需正确才可判定正确，因此使用 与逻辑符 \&\&&& 连接。
 * p = jp=j ： 判断 此树 是否正确。
 * recur(i, m - 1)recur(i,m−1) ： 判断 此树的左子树 是否正确。
 * recur(m, j - 1)recur(m,j−1) ： 判断 此树的右子树 是否正确。
 *
 * @author mai.gq
 * @date 2020/9/1
 */
public class Jianzhi33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
