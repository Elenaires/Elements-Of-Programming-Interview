/* qs 5.5 variant */

public class RemoveKey
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{6,6,6,6};
		int key = 1;
		
		int numElements = removeKeyOccurence(arr);
	
		System.out.println(numElements);
	}

	//update array so that all occurences of key has been removed
	// and remaining elements shifted left to fill emptied indices
	public static int removeKeyOccurence(int[] arr)
	{
		int i = 0;
		for(int j = 0; j < arr.length; j++)
		{
			if(arr[j] != 2)
			{
				if(i != j)
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				i++;
			}
		}

		return i;
	}
}
