/* qs 5.5 */
/* edge case - empty array */

public class DeleteDuplicateFromSortedArray
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1};
		System.out.println(deleteDuplicate(arr));
	}

	public static int deleteDuplicate(int[] arr)
	{
		int i = 1;
		int j = 1;
		
		if(arr.length == 0)
		{
			return -1;
		}
	
		while(j < arr.length)
		{
			if(arr[j] != arr[j-1])
			{
				if(i != j)
				{
					arr[i] = arr[j];
				}
				i++;
			}
			j++;
		}

		return i;
	}
}
