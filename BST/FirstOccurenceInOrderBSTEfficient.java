/* qs 14.2 variant - efficient */

public Node firstOccurenceInOrderBST(Node node, int toFind)
{
	Node retNode = null;
	Node curr = node;
	boolean found = false;

	while(node != null && !found)
	{
		if(node.value >= toFind)
		{
			if(node.value != toFind)
			{
				node = node.left;
			}

			// if node.value == toFind
			else
			{
				retNode = node;
				node = node.left;
				found = true;

				while(node != null && node.value == toFind)
				{
					retNode = node;
					node = node.left;
				}
			} 
		}
		else
		{
			node = node.right;
		}
	}

	return retNode;
}
