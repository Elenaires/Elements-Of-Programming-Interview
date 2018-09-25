/* qs 5.9 */

import java.util.*;

public class EnumerateAllPrimesToN
{
	public static void main(String[] args)
	{
		List<Integer> myList = getPrimes(210);
		for(int a : myList)
		{
			System.out.print(a + " ");
		}
	}
	
	public static List<Integer> getPrimes(int num)
	{
		List<Integer> myList = new ArrayList<>();
		
		boolean[] arr = new boolean[num+1];

		Arrays.fill(arr, true);

		// 0 and 1 are not prime
		arr[0] = false;
		arr[1] = false;

		// O(n/2 + n/3 + n/5 + n/7 ...) ~~ O(n log log n)
		for(int i = 2; i < arr.length; i++)
		{
			if(arr[i])
			{
				myList.add(i);
				for(int j = i; j < arr.length; j += i)
				{
					arr[j] = false;
				}
			}
		}
		
		return myList;
	}
}
