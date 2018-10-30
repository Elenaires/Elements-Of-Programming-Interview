/* qs 7.8 - remove duplicates from a sorted list */

public class RemoveDuplicateFromSortedList
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(4);
		ListNode node8 = new ListNode(5);
		ListNode node9 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;

		ListNode root = removeDuplicates(node1);
		
		if(root != null)
		{
			ListNode curr = root;
			while(curr != null)
			{		
				System.out.println(curr.val);
				curr = curr.next;	
			}
		}
		else
		{
			System.out.println("root is null");
		}

	}

	public static ListNode removeDuplicates(ListNode root)
	{
		if(root == null)
		{
			return root;
		}

		ListNode slow = root;
		ListNode fast = root.next;

		while(fast != null)
		{
			if(slow.val != fast.val)
			{
				slow.next = fast;
				slow = fast;
			}
			fast = fast.next;
		}
		
		return root;
	}
}
