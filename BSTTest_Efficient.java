// question 14.1 - efficient - O(n)

public class BSTTest
{
	public static void main(String[] args)
	{
		// create a binary tree p

		boolean isBST = bstTest(p, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean bstTest(Node node, int min, int max)
	{
		boolean isBST;

		if(node == null)
		{
			isBST = true;
		}
	
		// a node should go to the left side if its <= root, right is > root
		else if(node.value <= min || node.value > max)
		{ 			
			isBST = false;
		}

		else
		{
			isBST = bstTest(node.left, min, node.value) && bstTest(node.right, node.value, max);
		}

		return isBST;
	}
}
