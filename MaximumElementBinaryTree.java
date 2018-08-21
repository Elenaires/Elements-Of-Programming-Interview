// 14.1 subproblem

public class MaximumElementBinaryTree
{
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
