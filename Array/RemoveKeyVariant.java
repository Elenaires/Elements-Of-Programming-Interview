public class RemoveKeyVariant
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{0,1,1,1,2,2,3,4,4,4};
		int m = 3;

		filter(arr, m);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	public static void filter(int[] arr, int m)
	{
		// m == 1 || m == 2 means no change to the array
		// since the requirement says if x appears m times in A
		// we update A so that x appears min(2,m) times
		// min(2,1) = 1, min(2,2) = 2
		if(m >= 3 && arr.length != 0)
		{
			updateArray(arr, m);
		}
	}
			

	public static void updateArray(int[] arr, int m)
	{
		int i = 0;
		int count = 1;

		for(int j = 1; j < arr.length; j++)
		{
			if(arr[j] != arr[j-1])
			{
				if(count == m)
				{
					int steps = i + 2;
					while(i < steps)
					{
						arr[i] = arr[j-1];
						i++;
					}
				}
				else
				{
					int steps = i + count;
					while(i < steps)
					{
						arr[i] = arr[j-1];
						i++;
					}
				}
				count = 1;
			}
			else
			{
				count++;
			}
		}
		
		if(count == m)
		{
			int steps = i + 2;
			while(i < steps)
			{
				arr[i] = arr[arr.length-1];
				i++;
			}
		}
		else
		{
			int steps = i + count;
			while(i < steps)
			{
				arr[i] = arr[arr.length-1];
				i++;
			}
		}

		// fill up the rest of the indices after last valid element		
		while(i < arr.length)
		{
			arr[i] = -1;
			i++;
		}
	}
}
