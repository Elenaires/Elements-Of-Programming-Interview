/* Given a list of stock price over time, find the greatest gain one can obtain
 3,9,2,4,5,10,2,20,1 - max gain is $18 (buy in at $2 and sell at $20)

/* edge case - empty array, array with 1 element */

import java.util.*;

public class BuySellStockOnce
{
	public static void main(String[] args)
	{
		int[] arr = {3, 9, 2, 4, 5, 10, 2, 20, 1};
		
		int smallestValue = arr[0];
		int maxDiff = 0;
		int diff = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] <= smallestValue)
			{	
				smallestValue = arr[i];
			}
			else		
			{	
				diff = arr[i] - smallestValue;
				if(maxDiff < diff)
				{
					maxDiff = diff;
				}
			}
		}				
		System.out.println("Greatest gain is " + maxDiff);
		
	}						
}
