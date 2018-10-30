/* qs 7.4 */
/* 1) get length of both list, and check if both list have the same tail node
* 2) if they have the same tail node then there is an overlap, proceed with step 3, else return null
* 3) traverse longer list by the different in length of both lists
* 4) traverse both list in tantem, stop when a common node is found
*/

public class OverlappingLists
{
	/*public static class ListNode
	{
		int val;
		ListNode next;
		public ListNode(int x)
		{
			val = x;
			next = null;
		}
	}*/

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node6.next = node4;
		node4.next = node5;
		//node5.next = node3;

		ListNode commonNode = findFirstCommonNode(node1, node6);

		if(commonNode != null)
		{
			System.out.println(commonNode.val);
		}
		else
		{
			System.out.println("no common node");	
		}
	}

	public static ListNode findFirstCommonNode(ListNode l1, ListNode l2)
	{
		if(l1 == null || l2 == null)
		{
			return null;
		}

		int lengthL1 = 0;
		int lengthL2 = 0;

		ListNode curr1 = l1;
		ListNode curr2 = l2;

		ListNode prev1 = null;
		ListNode prev2 = null;

		while (curr1 != null || curr2 != null)
		{
			if(curr1 != null)
			{
				lengthL1++;
				prev1 = curr1;
				curr1 = curr1.next;
			}			
			if(curr2 != null)
			{
				lengthL2++;
				prev2 = curr2;
				curr2 = curr2.next;
			}
		}

		ListNode commonNode = null;
		// the lists overlap if and only if both have the same tail node
		if(prev1 == prev2)
		{
			curr1 = l1;
			curr2 = l2;
			int diff = Math.abs(lengthL1 - lengthL2);

			if(lengthL1 > lengthL2)
			{
				while(diff > 0)
				{
					curr1 = curr1.next;
					diff--;
				}	
			}			
			else if(lengthL1 < lengthL2)
			{
				while(diff > 0)
				{
					curr2 = curr2.next;
					diff--;
				}
			}
			
			while(commonNode == null)
			{
				if(curr1.next.equals(curr2.next))
				{
					commonNode = curr1.next;
				}
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
		}

		return commonNode;
	}
}
