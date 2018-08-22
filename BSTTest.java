// Inefficient solution to problem 14.1

public class BSTTest
{
	public boolean bstTest(Node node)
	{
		boolean isBST;

		// this is for empty tree only
		if (node == null)
		{
			isBST = true;
		}
		
		else if (node.left != null && (node.value < findMax(node.left)))
		{
			isBST = false;
		}

		else if (node.right != null && (node.value > findMin(node.right)))
		{
			isBST = false;
		}
		
		else if (node.left != null && (!bstTest(node.left) || node.right != null && !bstTest(node.right)))
		{
			isBST = false;
		}
		
		else
		{
			isBST = true;
		}

		return isBST;
	}

	public int findMax(Node node)
	{
		int currentValue;

		if(node == null)
		{
			currentValue = Integer.MIN_VALUE;
		}
		
		else
		{
			int currentValue = node.value;
	
			int leftValue = findMax(node.left);

			int rightValue = findMax(node.right);

			int maxChildValue = Math.max(leftValue, rightValue);

			if(currentValue < maxChildValue)
			{
				currentValue = maxChildValue;
			}
		}

		return currentValue;
	}

	public int findMin(Node node)
	{
		int currentValue;

		if(node == null)
		{
			currentValue = Integer.MAX_VALUE;
		}

		else
		{
			currentValue = node.value;
			
 			int leftValue = findMin(node.left);

			int rightValue = findMin(node.left);
		
			int minChildValue = Math.min(leftValue, rightValue);
	
			if(currentValue < minChildValue)
			{
				currentValue = minChildValue;
			}

			return currentValue;
		}
	}
}
