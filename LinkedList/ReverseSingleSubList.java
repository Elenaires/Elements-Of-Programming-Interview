/* qs 7.2 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(head == null)
        {
            return null;
        }
        
        // counter is set to 1 as head is considered as 1
        int counter = 1;
        ListNode current = head;
        ListNode previous = null;
        
        // traverse the list until we find mth listnode (current)
        while(counter != m)
        {
            previous = current;
            current = current.next;
            counter++;
        }
        
        ListNode reversedHead = reverse(current, counter, n);
        
        // if the head is being reversed then we return new head
        if(m == 1)
        {
            return reversedHead;
        }
        
        // otherwise the head remains the same after sublist reversal
        else
        {
            // point the last listnode that is not being reversed to the head of 
            // the reversed sublist
            previous.next = reversedHead;
            return head;
        }
    }
    
    public ListNode reverse(ListNode head, int counter, int end)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        int start = counter;
        
        // reverse the sublist until and include the nth node 
        while(start <= end)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            start++;
        }
        
        // if the nth node is not the last listnode of the linked list
        // we need to point mth node (now last node of the reversed list)
        // to nth.next node (curr)
        if(curr != null)
        {
            head.next = curr;
        }

        // prev is now the head of the reversed sublist
        return prev;
    }
}
