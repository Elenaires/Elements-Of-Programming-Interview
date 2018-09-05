/* qs 5.1 - Variant A 
*/

public class DutchNationalFlagVariantA
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,1,1,2,3,2,1,2,1,3,1,1,1,1};

		partition(arr);

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	public static void partition(int[] arr)
	{
		int startIdx = 1;
		int endIdx = arr.length-1;
	
		int startValue = arr[0];
		int endValue;

		int i = 1;

		// if startValue and last elements are different
		// we set last element as endValue
		// so now we have 2 values positioned at both ends
		if(startValue != arr[endIdx])
		{
			endValue = arr[endIdx];

			// this is because we know arr[endIdx] is already at
			// the correct position so we start with endIdx--
			endIdx--;
		}

		// if both startValue and last element are the same {1,1,2,3,2,3,1}
		// we need to swap the first occurence of value not equal to startValue
		// with the last element {1,1,1,3,2,3,2}
		// so now we have a different startValue and last element
		// and we label last element as the endValue
		// again now we have 2 distinced values positioned at both ends
		else
		{
			// positioning startIdx ie. {1,1,1,1,2,3}
			// startIdx should be 4 not 1	
			while(arr[i] == arr[i-1])
			{
				i++;
				startIdx++;
			}

			int temp = arr[i];
			arr[i] = arr[endIdx];
			arr[endIdx] = temp;
			endValue = arr[endIdx];

			// we know arr[endIdx] and arr[startIdx] are correctly positioned
			// so we shift the index by 1
			endIdx--;
			i++;
			startIdx++;
		}
		
		while(i <= endIdx)
		{
			if(arr[i] == startValue)
			{
				if(i != startIdx)
				{
					int temp = arr[startIdx];
					arr[startIdx] = arr[i];
					arr[i] = temp;
				}
				startIdx++;
				i++;
			}
			else if(arr[i] == endValue)
			{
				if(i != endIdx)
				{
					int temp = arr[endIdx];
					arr[endIdx] = arr[i];
					arr[i] = temp;
				}
				endIdx--;
			}
		
			// if value does not equal start or end value
			// we dont need to swap because it is already
			// at the right position (in the middle)
			else
			{
				i++;
			}
		}	
	}
}
