/* qs 7.11 */
public class TestForPalindromic
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node6 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node6;
		node6.next = node4;
		node4.next = node5;

		boolean isPalindrome = testPalindrome(node1);
		System.out.println(isPalindrome);

		ListNode curr = node1;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static boolean testPalindrome(ListNode root)
	{
		if(root == null)
		{
			return false;
		}

		if(root.next == null)
		{
			return true;
		}

		// find the mid point of the list
		ListNode fast = root;
		ListNode slow = root;
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode firstHead = root;

		// reverse list starting from slow
		ListNode secondHead = reverseList(slow);
			
		boolean isPalindrome = true;

		// traverse firstHead and secondHead in tandem checking their values
		while(firstHead != null && secondHead != null && isPalindrome)
		{
			if(firstHead.val != secondHead.val)
			{
				isPalindrome = false;
			}
			firstHead = firstHead.next;
			secondHead = secondHead.next;
		}

		// restore the list back to its original sequence
		ListNode secondHalf = reverseList(slow);
		
		return isPalindrome;
	}

	public static ListNode reverseList(ListNode start)
	{
		ListNode curr = start.next;
		while(curr.next != null)
		{
			ListNode temp = start.next;
			start.next = curr.next;
			curr.next = start.next.next;
			start.next.next = temp;
		}

		return start.next;
	}
}
