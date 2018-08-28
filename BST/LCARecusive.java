/* qs 14.4 - recursive */

public Node LCA(Node node, Node A, Node B)
{
	Node lca = null;
	
	if(node.value > A && node.value > B)
	{
		lca = LCA(node.left, A, B);
	}
	else if(node.value < A && node.value < B)
	{
		lca = LCA(node.right, A, B);
	}
	else
	{
		lca = node;
	}

	return lca;
} 
