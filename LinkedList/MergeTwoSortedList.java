/* qs 7.1 - iterative */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                current.next = p1;
                p1 = p1.next;
            }
            else
            {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }
        
        current.next = p1 == null ? p2 : p1;
        
        return dummy.next;
        
    }
}
