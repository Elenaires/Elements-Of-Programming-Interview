/* qs 7.7 remove the kth last element from a linked list without additional space */

public class RemoveKthLastElement
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		removeKthLastNode(node1, 2);

		ListNode curr = node1;
		while(curr!= null)
		{
			System.out.println(curr.val);
			curr = curr.next;	
		}
	}

	public static void removeKthLastNode(ListNode root, int k)
	{
		ListNode a = root;
		ListNode b = root;

		// advance b k nodes ahead
		while(k > 0)
		{
			b = b.next;
			k--;
		}
	
		// advance a to the node before kth last element
		while(b.next != null)
		{
			a = a.next;
			b = b.next;
		}

		a.next = a.next.next;		
	}	
}
