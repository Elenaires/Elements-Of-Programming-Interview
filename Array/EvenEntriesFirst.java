/* 5.0 array bootcamp
* reorder array so that even entries appear first without incurring 
* additional space */

public class EvenEntriesFirst
{
	public static void main(String[] args)
	{
		int[] array = new int[]{2,5,4,3,10,2,4,3,5,7,1,3,2,4,20};

		reorderArray(array);

		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}		
	}

	// with this method {2,2,2,1,2,2,2,2} requires multiple swaps of 1 with 2 all the way to the end
	/*public static void reorderArray(int[] array)
	{
		int i = 0;

		for(int j = 1; j < array.length; j++)
		{
			if(array[j] % 2 == 0 && array[i] % 2 != 0)
			{
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
			else if(array[i] % 2 == 0)
			{
				i = j;
			}
		}
	}*/

	// solution from EPI
	public static void reorderArray(int[] array)
	{
		int start = 0;
		int end = array.length - 1;

		while(start < end)
		{
			if(array[start] % 2 == 0)
			{
				start++;
			}
			else
			{
				int temp = array[end];
				array[end] = array[start];
				array[start] = temp;
				end--;
			}
		}
	}
}
			

