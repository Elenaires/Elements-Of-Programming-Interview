/* qs 5.3 */

import java.util.*;

public class MultiplyIntegerArray
{
	public static void main(String[] args)
	{
		List<Integer> num1 = new ArrayList<>(Arrays.asList(0));
		List<Integer> num2 = new ArrayList<>(Arrays.asList(987));

		List<Integer> result = multiply(num1, num2);

		for(int i : result)
		{
			System.out.print(i + " ");
		}
	}

	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2)
	{
		// create an ArrayList of total size of num1 plus num2 and initialize elements to 0
		// since maximum digits of the product is size of num1 plus size of num2
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

		// determine sign of product
		int sign = (num1.get(0) < 0) ^ (num2.get(0) < 0) ? -1 : 1;

		// remove negative sign for both numbers
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));

		int sizeA = num1.size();
		int sizeB = num2.size();

		int largestNumber = Math.max(sizeA, sizeB);
		int smallerNumber = Math.min(sizeA, sizeB);

		for(int i = smallerNumber - 1; i >= 0; i--)
		{
			for(int j = largestNumber - 1; j >= 0; j--)
			{
				result.set(i + j + 1, result.get(i+j+1) + num1.get(i) * num2.get(j));
				result.set(i + j, result.get(i+j) + result.get(i+j+1)/10);
				result.set(i + j + 1, result.get(i+j+1) % 10);
			}
		}

		// remove leading zero, first identify first digit that's not zero
		int i = 0;
		while(i < result.size() && result.get(i) == 0)
		{
			i++;	
		}

		// truncate result
		result = result.subList(i, result.size());

		if(!result.isEmpty())
		{
			result.set(0, result.get(0) * sign);
		}
		else
		{
			result = Arrays.asList(0);
		}

		return result;
	}
}		
