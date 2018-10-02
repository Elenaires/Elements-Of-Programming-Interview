/* qs 7.1 variant - iterative */

/**
 * Definition for doubly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *	   ListNode prev;
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
				p1.prev = current;
                p1 = p1.next;
            }
            else
            {
                current.next = p2;
				p2.prev = current;
                p2 = p2.next;
            }
            current = current.next;
        }
       
        if(p1 == null)
		{
			current.next = p2;
			p2.prev = current;
		}
		else if(p2 == null)
		{
			current.next = p1;
			p1.prev = current;
		}
		
        return dummy.next;
        
    }
}
