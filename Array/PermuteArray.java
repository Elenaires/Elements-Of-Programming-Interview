/* qs 5.10 */
/* O(n) with no additional storage required */

import java.util.*;

public class PermuteArray
{
	public static void main(String[] args)
	{
		char[] array = new char[]{'a','b','c','d','e','f','g'};
		int[] permutation = new int[]{6,1,5,2,0,3,4};

		permuteArray(array, permutation);

		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public static void permuteArray(char[] array, int[] permutation)
	{
		// instead of creating a new boolean array
		// make use of permutation array, assign -ve sign to the corresponding
		// element
		//boolean[] correctPosition = new boolean[array.length];
		//Arrays.fill(correctPosition, false);

		for(int i = 0; i < array.length; i++)
		{
			//if(i != permutation[i] && !correctPosition[i])
			if(i != permutation[i] && permutation[i] >= 0)
			{
				char temp = array[i];
				array[i] = array[permutation[i]];
				array[permutation[i]] = temp;
				//correctPosition[permutation[i]] = true;
				permutation[permutation[i]] *= -1;
			}
		}

		//restore permutation
		for(int i = 0; i < permutation.length; i++)
		{
			permutation[i] = Math.abs(permutation[i]);
			System.out.print(permutation[i] + " ");
		}
	}
}
