/* qs 7.5 */
/* 1) if both list has no cycle - find overlap as usual qs 7.4
* 2) if both list has cycles 
*    i) determine if they have the same cycle 
*    ii) different cycle - disjoint - no overlap node
* 3) if 2i) determine if the overlap node occurs before the cycle or after the cycle
*    Advance the list that's longer by the difference in length (distance from root to cycle for both lists)
* 4) traverse both list at tantem while l1 != l2 && l1 != cycle1 && l2 != cycle2 (while l1 and l2 have not entered the cycle)
* 5) if l1 == l2 then return l1 (or l2)
* 6) else return cycle1 (or cycle2)
*/

import java.util.*;
public class OverlappingListsWithCycle
{
	/*public static class ListNode
	{
		int val;
		ListNode next = null;
		public ListNode(int val)
		{
			this.val = val;
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
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;

		ListNode node = overlappedNode(node1, node6);
		if(node != null)
		{
			System.out.println(node.val);
		}
		else
		{
			System.out.println("no overlapping node");
		}
	}

	public static ListNode overlappedNode(ListNode l1, ListNode l2)
	{
		ListNode overlapped = null;

		ListNode cycleL1 = testCycle(l1);
		ListNode cycleL2 = testCycle(l2);

		// both list have no cycle
		if(cycleL1 == null && cycleL2 == null)
		{
			overlapped = OverlappingLists.findFirstCommonNode(l1, l2);
		}
		
		// both list have cycle
		else if(cycleL1 != null && cycleL2 != null)
		{	
			ListNode temp = cycleL1;
			do
			{
				temp = temp.next;
			} while (temp != cycleL1 & temp != cycleL2);

			// l1 and l2 share the same cycle
			if(temp == cycleL2)
			{
				int stem1Length = distance(l1, cycleL1);
				int stem2Length = distance(l2, cycleL2);

				int diff = Math.abs(stem1Length - stem2Length);

				if(stem1Length > stem2Length)
				{
					l1 = advanceListByK(diff, l1);
				}
				else
				{
					l2 = advanceListByK(diff, l2);
				}

				// check if overlap occurs before the cycle
				while(l1 != l2 && l1 != cycleL1 && l2 != cycleL2)
				{
					l1 = l1.next;
					l2 = l2.next;
				}

				// overlap occurs before the cycle
				if(l1 == l2)
				{
					overlapped = l1;
				}
				else
				{
					overlapped = cycleL1;
				}
			}
			// else l1 and l2 do not share the same cycle thus no overlapped
		}
	
		// else only 1 list has cycle - definitely not overlap

		return overlapped;
	}

	public static ListNode testCycle(ListNode head)
	{
		HashSet<ListNode> set = new HashSet<>();

		ListNode current = head;

		while(current != null && !set.contains(current))
		{
			set.add(current);
			current = current.next;
		}
		
		ListNode result = (current != null) ? current : null;

		return result;
	}

	public static int distance(ListNode root, ListNode node)
	{
		int count = 0;
		while(root != node)
		{
			root = root.next;
			count++;
		}			
		return count;
	}

	public static ListNode advanceListByK(int count, ListNode list)
	{
		while(count > 0)
		{
			list = list.next;
			count--;
		}

		return list;
	}
}
