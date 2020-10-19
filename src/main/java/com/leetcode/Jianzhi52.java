package com.leetcode;


import com.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 *
 * @author mai.gq
 * @date 2020/10/19
 */
public class Jianzhi52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();
        //先把链表A的结点全部存放到集合set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
        return null;
    }

}
