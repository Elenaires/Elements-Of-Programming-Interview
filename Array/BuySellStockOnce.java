/* qs 5.6 */

public class BuySellStockOnce
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit(arr));

	}
	
	public static int maxProfit(int[] arr)
	{
		if(arr.length == 0)
		{
			return 0;
		}

		int buy = arr[0];
		int sell;
		int profit = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] < buy)
			{
				buy = arr[i];
			}
			else if(arr[i] > buy)
			{
				sell = arr[i];
				profit = Math.max(profit, sell - buy);
			}
		}
		return profit;
	}
}
