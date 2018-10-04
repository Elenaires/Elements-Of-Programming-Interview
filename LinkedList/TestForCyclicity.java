/* qs 7.3 - with extra space */

import java.util.*;

public class TestForCyclicity
{
	public static class Node
	{
		int val;
		Node next = null;
		
		public Node(int x)
		{
			val = x;
		}
	}

	public static void main(String[] args)
	{
		Node head = new Node(11);
		Node node1  = new Node(7);
		Node node2 = new Node(5);
		Node node3 = new Node(3);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		Node result = testCycle(head);
		System.out.println(result.val);
	}

	public static Node testCycle(Node head)
	{
		HashSet<Node> set = new HashSet<>();

		Node current = head;

		while(current != null && !set.contains(current))
		{
			set.add(current);
			current = current.next;
		}
		
		Node result = (current != null) ? current : null;

		return result;
	}
}
