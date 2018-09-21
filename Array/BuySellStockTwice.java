/* qs 5.7 */

public class BuySellStockTwice
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{5,8,1,2,7,6,10,11,5};
		System.out.println(maxProfit(arr));
	}
		
	public static int maxProfit(int[] arr)
	{
		// store maxprofit going forward from Day 1 to Day n
		int[] firstProfit = new int[arr.length];

		int buy = arr[0];
		int profit = 0;
		int sell;

		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] <= buy)
			{
				buy = arr[i];
			}
			else
			{
				sell = arr[i];
				profit = Math.max(profit, sell - buy);
			}
			firstProfit[i] = profit;
		}

		int maxProfit = 0;
		sell = arr[arr.length-1];
		profit = 0;

		// calc profit backward
		// ie sell on Day n buy on Day n-1 etc
		for(int i = arr.length-1; i > 0; i--)
		{
			if(arr[i] >= sell)
			{
				sell = arr[i];
			}
			else
			{
				buy = arr[i];
				profit = Math.max(profit, sell - buy);
			}
			maxProfit = Math.max(maxProfit, firstProfit[i-1] + profit);
		}				
		return maxProfit;
		
	}
}
