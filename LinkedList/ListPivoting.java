/* qs 7.12 */
/* 1) create 3 dummy listnode (lessThan, equal, greaterThan)
* 2) traverse the list and assign each node as the next node to the appropriate dummy node
* 3) assign the greaterThan next to null
* 4) assign the equalTo next to the start of greaterThan
* 5) assign the lessThan next to the start of the equal
*/
 
public class ListPivoting
{
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(0);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(10);
		ListNode node9 = new ListNode(3);
		ListNode node10 = new ListNode(2);
		ListNode node11 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;

		ListNode newHead = listPivoting(node1, 3);

		ListNode curr = newHead;
		while(curr != null)
		{
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static ListNode listPivoting(ListNode head, int k)
	{	
		ListNode dummyLessThanK = new ListNode(0);
		ListNode dummyEqualToK = new ListNode(0);
		ListNode dummyGreaterThanK = new ListNode(0);
		ListNode lessThanKIter = dummyLessThanK;
		ListNode equalToKIter = dummyEqualToK;
		ListNode greaterThanKIter = dummyGreaterThanK;

		ListNode curr = head;

		while(curr != null)
		{
			if(curr.val < k)
			{
				lessThanKIter.next = curr;
				lessThanKIter = curr;
			}
			else if(curr.val == k)
			{
				equalToKIter.next = curr;
				equalToKIter = curr;
			}
			else
			{
				greaterThanKIter.next = curr;
				greaterThanKIter = curr;
			}
			curr = curr.next;
		}
		
		greaterThanKIter.next = null;
		equalToKIter.next = dummyGreaterThanK.next;
		lessThanKIter.next = dummyEqualToK.next;

		return dummyLessThanK.next;
	}
}
