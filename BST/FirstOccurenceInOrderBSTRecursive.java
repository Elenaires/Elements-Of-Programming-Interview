/* qs 14.2 variant - recursive */

public Node firstOccurence(Node node, int val)
{
	Node retNode = null;

	if(node == null)
	{
		retNode = null;
	}
	else if(node.value > val)
	{
		retNode = firstOccurence(node.left, val);
	}
	else if(node.value < val)
	{
		retNode = firstOccurence(node.right, val);
	}
	else if(node.value == val)
	{
		retNode = node;
		node = node.left;

		while(node != null && node.val == val)
		{
			retNode = node;
			node = node.left;
		}
	}
	
	return retNode;
}
		
