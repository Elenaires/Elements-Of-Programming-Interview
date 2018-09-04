/* qs 5.1 
*/

public class DutchNationalFlag
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{2,1,3,4,1,5,0,1,3};

		partition(arr, 0);

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
