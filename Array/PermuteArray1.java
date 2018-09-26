/* qs 5.10 */

import java.util.*;

public class PermuteArray1
{
	public static void main(String[] args)
	{
		char[] array = new char[]{'a','b','c','d'};
		int[] permutation = new int[]{2,0,1,3};

		char[] result = permuteArray(array, permutation);

		for(int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + " ");
		}
	}
	
	public static char[] permuteArray(char[] array, int[] permutation)
	{
		char[] result = new char[array.length];

		for(int i = 0; i < array.length; i++)
		{
			result[permutation[i]] = array[i];
		}
		
		return result;
	}
}
