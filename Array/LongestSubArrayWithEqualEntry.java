/* qs 5.6 variant */

public class LongestSubArrayWithEqualEntry
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{3,3};
		System.out.println(longestSubarray(arr));
	}

	public static int longestSubarray(int[] arr)
	{
		// edge case - empty array or array with 1 element
		if(arr.length == 0 || arr.length == 1)
		{
			return 0;
		}

		int length = 1;
		int maxLength = 0;

		for(int i = 1; i < arr.length; i++)
		{
			if(arr[i] == arr[i-1])
			{
				length++;
			}
			else
			{
				if(length != 1)
				{
					maxLength = Math.max(maxLength, length);
				}

				length = 1;
			}
		}
	
		if(length != 1)
		{
			maxLength = Math.max(maxLength,length);
		}

		return maxLength;
	}
}
