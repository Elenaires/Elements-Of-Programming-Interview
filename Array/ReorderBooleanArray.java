/* qs 5.1 - variant c */

public class ReorderBooleanArray
{
	public static void main(String[] args)
	{
		boolean[] arr = new boolean[]{true, false, false, true, true, false, true, false, false};
		reorderArray(arr);

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}		
	}
	
	public static void reorderArray(boolean[] arr)
	{
		int start = 0;
		int end = arr.length - 1;
	
		while(start < end)
		{
			if(arr[start])
			{
				boolean temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
				end--;
			}
			else
			{
				start++;
			}
		}
				
	}
}
