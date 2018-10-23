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
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(6);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;

		Node result = testCycle(head);
		System.out.println(result.val);
		
	}

	public static Node testCycle(Node head)
	{
		Node slow = head;
		Node fast = head;

		int cycleLength = 0;

		// return cycleHead is cycle exist
		// otherwise return null
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;

			// cycle found
			if(slow == fast)
			{
				//Node cycleHead = findCycleHead(head, slow, fast);
				//return cycleHead;
				Node slowTemp = head;
				while(slowTemp != slow)
				{
					System.out.println("slow val : " + slow.val);
					System.out.println("slowTemp val : " + slowTemp.val);
					slowTemp = slowTemp.next;
					slow = slow.next;
				}
				return slow;
			}
		}

		return null;
	}

	/*public static Node findCycleHead(Node head, Node slow, Node fast)
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
	}*/
}
			
			

		

			
			
