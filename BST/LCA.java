/* qs 14.4 - iterative */
/* assumes no identical nodes */
/* A and B must present in the bst */

public Node LCA(Node node, Node A, Node B)
{
	boolean found = false;
	
	while(!found)
	{
		if(node.value > A.value && node.value > B.value)
		{
			node = node.left;
		}
		else if(node.value < A.value && node.value < B.value)
		{
			node = node.right;
		}
		else
		{
			found = true;
		}
	}

	return node;
}	
