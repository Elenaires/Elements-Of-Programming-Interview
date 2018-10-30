/* qs 7.6 - delete a node from a singly linked list */
/* node is guaranteed not to be the tail node */

public class DeleteNodeSinglyLinkedList
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;

		deleteNode(node2);
		
		ListNode curr = node1;
		while(curr!= null)
		{
			System.out.println(curr.val);
			curr = curr.next;
		}
	}
	
	public static void deleteNode(ListNode node)
	{
		node.val = node.next.val;
		node.next = node.next.next;		
	}
}
