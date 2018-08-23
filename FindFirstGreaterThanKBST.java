// question 14.2 - time complexity is O(lgn)

/*public class Node
{
	int key;
	Node left;
	Node right;
}
*/

public static Integer firstGreaterThanK(Node node, int value)
{
	Node current = node;
	Node firstGreaterNode = null;
	Integer firstGreaterVal = null;

	while(current != null)
	{
		if(current.key > value)
		{
			firstGreaterNode = current;
			current = current.left;
		}
		else
		{
			current = current.right;
		}		
	}

	if (firstGreaterNode != null)
	{
		firstGreaterVal = firstGreaterNode.key;
	}
	
	return firstGreaterVal;
}
				
