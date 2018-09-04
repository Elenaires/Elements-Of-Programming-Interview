/* qs 5.1 
*/

public class DutchNationalFlag
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,2,3,10,2,3,15,4,5,6,10};

		partition(arr, 3);

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	public static void partition(int[] arr, int index)
	{
		int start = 0;
		int end = arr.length - 1;
		
		int i = 0;

		int pivot = arr[index];

		while(i <= end)
		{
			if(arr[i] < pivot)
			{
				if(i != start)
				{
					int temp = arr[i];
					arr[i] = arr[start];
					arr[start] = temp;
				}
				i++;
				start++;
			}
			else if(arr[i] > pivot)
			{
				if(i != end)
				{
					int temp = arr[i];
					arr[i] = arr[end];
					arr[end] = temp;
				}
				end--;
			}
			else
			{
				i++;
			}
		} 
	}
}
