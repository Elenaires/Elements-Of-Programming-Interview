/* qs 7.3 - without additional space */

public class TestForCyclicityWithoutExtraSpace
{
	public static class Node
	{
		int val;
		Node next;
		public Node(int val)
		{
			this.val = val;
		}
	}

	public static void main(String[] args)
	{
		Node head = new Node(11);
		Node node1 = new Node(7);
		Node node2 = new Node(5);
		Node node3 = new Node(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		Node result = testCycle(head);
		System.out.println(result.val);
		
	}

	public static Node testCycle(Node head)
	{
		Node slow = head;
		Node fast = head;

		int cycleLength = 0;

		// return cycleHead is cycle exist
		// otherwise return original head
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			// cycle found
			if(slow == fast)
			{
				Node cycleHead = findCycleHead(head, slow, fast);
				return cycleHead;
			}
		}

		return head;
	}

	public static Node findCycleHead(Node head, Node slow, Node fast)
	{
		// find cycle length
		int cycleLength = 0;
		do
		{
			fast = fast.next;
			cycleLength++;
		} while(fast != slow);

		Node fastNode = head;
		Node slowNode = head;

		// move fastNode cycleLength ahead
		while(cycleLength-- > 0)
		{
			fastNode = fastNode.next;
		}

		// traverse both fast and slow node until they meet
		// and that's the head of the cycle
		while(fastNode != slowNode)
		{
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}

		// or fastNode
		return slowNode;
	}
}
			
			

		

			
			
