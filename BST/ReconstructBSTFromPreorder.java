/* qs 14.5 - recursive - inefficient 
* assumption : elements stored in the tree are unique
* reconstruct BST from preorder traversal
*/

public class Node
{
	int key;
	Node left;
	Node right;
}

public static Node rebuildBSTFromPreorder(List<Integer> preorder)
{
	Node node = helper(preoder, 0, preorder.size());
}

public static Node helper(List<Integer> preorder, int start, int end)
{
	Node node;

	if(start <= end)
	{
		node = null;
	}
	else
	{
		int transition = start + 1;
		
		/* O(n) if tree is left skewed */
		while(transition < end && (preorder.get(transition) < preorder.get(start)))
		{
			transition++;
			
		}

		Node left = helper(preorder, start+1, transition);
		Node right = helper(preorder, transition, end);

		node = new Node(preorder.get(start), left, right);
	}

	return node;
}	
