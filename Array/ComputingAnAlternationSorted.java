/* qs 5.8 - O(nlgn) - with sorting */

import java.util.*;

public class ComputingAnAlternationSorted
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,3,6,2,3,4,5,7};
		int[] newArr = computingAnAlternation(arr);
		
		for(int i = 0; i < newArr.length; i++)
		{
			System.out.print(newArr[i] + " ");
		}
	}

	public static int[] computingAnAlternation(int[] arr)
	{
		Arrays.sort(arr);

		int[] newArr = new int[arr.length];

		// split array into half then interleave bottom and top halves		
		int mid = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;

		int a = 0, b = mid;

		for(int i = 0; i < newArr.length; i++)
		{
			if(i % 2 == 0)
			{
				newArr[i] = arr[a];
				a++;
			}
			else 
			{
				newArr[i] = arr[b];
				b++;				
			} 
		}

		return newArr;
	}
}
