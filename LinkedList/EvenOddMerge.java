/* qs 7.10 */
import java.util.*;
public class EvenOddMerge
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
			
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		ListNode newHead = evenOddMerge(node1);
		ListNode curr = newHead;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();	
	}

	public static ListNode evenOddMerge(ListNode root)
	{
		if(root == null)
		{
			return root;
		}

		ListNode dummyEven = new ListNode(0);
		ListNode dummyOdd = new ListNode(0);

		List<ListNode> myList = new ArrayList<>();

		myList.add(dummyEven);
		myList.add(dummyOdd);

		ListNode curr = root;
		int index = 0;
		while(curr != null)
		{
			myList.get(index).next = curr;
			myList.set(index, myList.get(index).next);
			index ^= 1;
			curr = curr.next;
		}

		myList.get(1).next = null;
		myList.get(0).next = dummyOdd.next;

		return root;
	}
}
