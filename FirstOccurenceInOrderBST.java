/* qs 14.2 variant - uses iterative inorder traversal with stack
* time complexity is O(n) as we need to visit every single node
* in the worst case */

public Node firstOccurenceInOrderBST(Node node, int toFind)
{
	Stack<Node> stack = new Stack<>();

	Node current = node;
	boolean found = false;

	while((current != null || !stack.isEmpty()) && !found)
	{
		// keep travesing left until null
		while(current != null)
		{
			stack.push(node);
			current = current.left;
		}
		
		current = stack.pop();

		if(current.value != toFind)
		{
			current = current.right;
		}
		else
		{
			found = true;
		}
	}

	return current;
}
