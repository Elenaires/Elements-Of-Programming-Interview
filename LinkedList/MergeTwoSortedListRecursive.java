/* qs 7.1 - recursive */

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
      	ListNode h1 = l1;
		ListNode h2 = l2;
	
		ListNode result;

		if(h1 == null)
		{
			result = h2;
		}
		else if(h2 = null)
		{
			result = h1;
		}
		else if(h1.val <= h2.val)
		{
			result = h1;
			h1.next = mergeTwoLists(h1.next, h2);
		}
		else
		{
			result = h2;
			h2.next = mergeTwoLists(h1, h2.next);
		}
		return result;
	}
}

