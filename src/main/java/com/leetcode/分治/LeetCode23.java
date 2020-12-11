package com.leetcode.分治;

import com.leetcode.common.ListNode;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author mai.gq
 * @date 2020/11/20
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int left = 0;
        int right = lists.length - 1;
        return merge(left, right, lists);
    }


    private ListNode merge(int left, int right, ListNode[] listNodes) {
        if (left == right) return listNodes[left];
        if (left > right) return null;
        int mid = (left + right) >> 1;
        ListNode leftNode = merge(left, mid, listNodes);
        ListNode rightNode = merge(mid + 1, right, listNodes);
        if (leftNode == null || rightNode == null) {
            return leftNode != null ? leftNode : rightNode;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val > rightNode.val) {
                cur.next = rightNode;
                rightNode = rightNode.next;
            } else {
                cur.next = leftNode;
                leftNode = leftNode.next;
            }
            cur = cur.next;
        }
        cur.next = leftNode != null ? leftNode : rightNode;
        return head.next;
    }


//    private ListNode merge(int left, int right, ListNode[] listNodes) {
//        if(left==right) return listNodes[left];
//        if(left>right) return null;
//        int mid = (left + right) >> 1;
//        ListNode leftNode = merge(left, mid, listNodes);
//        ListNode rightNode = merge(mid+1,right, listNodes);
//        if (leftNode == null || rightNode == null) {
//            return leftNode != null ? leftNode : rightNode;
//        }
//        ListNode head = new ListNode(0);
//        ListNode cur = head, lPtr = leftNode, rPrt = rightNode;
//        while (lPtr != null && rPrt != null) {
//            if (lPtr.val <= rPrt.val) {
//                cur.next = lPtr;
//                lPtr = lPtr.next;
//            }else {
//                cur.next = rPrt;
//                rPrt = rPrt.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = (lPtr != null ? lPtr : rPrt);
//        return head.next;
//    }
}
