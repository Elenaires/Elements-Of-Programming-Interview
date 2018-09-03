/* 5.0 array bootcamp
* reorder array so that even entries appear first without incurring 
* additional space */

public class EvenEntriesFirst
{
	public static void main(String[] args)
	{
		int[] array = new int[]{3,8,2,1,1,4,1,3,4,10,1,2};

		reorderArray(array);

		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}		
	}

	public static void reorderArray(int[] array)
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
	}
}
			

