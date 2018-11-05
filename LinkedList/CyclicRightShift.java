/* qs 7.9 */

public class CyclicRightShift
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode newHead = rightShift(node1, 1);
		ListNode curr = newHead;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static ListNode rightShift(ListNode root, int k)
	{
		// if root is null, return null
		if(root == null)
		{
			return root;
		}

		// find length of the list
		int length = 1;
		ListNode tail = root;
		while(tail.next != null)
		{
			tail = tail.next;
			length++;
		}
				
		// this is a check - since k can be greater than length
		k = k % length;
	
		// if k is 0 then no shift is needed
		if(k == 0)
		{
			return root;
		}	

		// connect tail to the root
		tail.next = root;

		// since it's a singly linked list, we cant traverse backward
		// to get to kth node from the right, we need to traverse
		// length - k + 1 times forward from the tail
		// However, we also need to get access to the new tail
		// therefore we will only traverse length - k steps
		int steps = length - k;

		while(steps > 0)
		{
			tail = tail.next;
			steps--;
		}

		// new head is after the new tail
		ListNode head = tail.next;

		// sever the link between new tail and new head
		tail.next = null;

		return head;	
	}
}
