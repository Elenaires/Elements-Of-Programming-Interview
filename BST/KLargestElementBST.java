// qs 14.3 - iterative - reversed of inorder traversal (traverse right then left)

public List<Integer> KLargestElementBST(Node node, int k)
{
	List<Integer> myList = new ArrayList<>();
	Stack<Node> stack = new Stack<>();

	Node current = node;
	
	while(myList.size() < k && (current != null || !stack.isEmpty()))
	{
		while(current != null)
		{
			stack.add(current);
			current = current.right;
		}

		current = stack.pop();
		myList.add(current.value);
		current = current.left;
	}

	return myList;
}
