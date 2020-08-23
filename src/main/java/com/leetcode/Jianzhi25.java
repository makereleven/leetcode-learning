package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/8/3
 */
public class Jianzhi25 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                res = l1;
                l1 = l1.next;
            }else{
                res = l2;
                l2 = l2.next;
            }
            res =  res.next;
        }
        if(l1!=null)res.next = l1;
        if(l2!=null){res.next =l2;}
        return res;
    }
}
