/* qs 5.2 */

import java.util.*;

public class IncrementIntegerArray
{
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(8,9,8));
		
		incrementArray(list);

		for(int a : list)
		{
			System.out.print(a + " ");
		}
	}
	
	public static void incrementArray(List<Integer> list)
	{
		boolean keepGoing = true;

		int i = list.size() - 1;

		while(i >= 0 && keepGoing)
		{
			int newValue = (list.get(i) + 1) % 10;
		
			list.set(i, newValue);

			if(newValue != 0)
			{
				keepGoing = false;
			}
			i--;
		}

		if(keepGoing)
		{
			list.set(0, 1);
			list.add(0);
		}
	}
}
