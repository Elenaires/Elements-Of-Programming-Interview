/* 5.11 */

/* example 6,2,1,5,4,3,0
* 1) start from the end of array, look for the first entry
* that's smaller than next entry - 1 (since 1 is smaller than 5)
* 5 > 4 > 3 > 0 (suffix) , 6,2,1(prefix)
* 2) among 5,4,3,0, start from the back, look for the first entry
* that's greater than 1 (smallest entry that's greater than 1)
* it's 3.
* 3) swap 1 and 3
* 4) now we have 6,2,3,5,4,1,0
* 5) reorder 5,4,1,0 to get smallest permutation
* by just swapping front and end entries since it's already in descending order
* do not need to employ a full blown sorting
*/

import java.util.*;

public class ComputeNextPermutation
{
	public static void main(String[] args)
	{
		List<Integer> myList = new ArrayList<>();
		myList.add(6);
		myList.add(2);
		myList.add(1);
		myList.add(5);
		myList.add(4);
		myList.add(3);
		myList.add(0);
		
		nextPermutation(myList);
		for(int a : myList)
		{
			System.out.print(a + " ");
		}
	}

	public static void nextPermutation(List<Integer> list)
	{
		int i = list.size() - 2;

		// find first entry from the end of list that's
		// smaller than it's next entry
		while(i >= 0 && list.get(i) > list.get(i+1))
		{
			i--;
		}

		if(i < 0)
		{
			//the below does not work - java is pass by value!!!
			//https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value/12429953#12429953
			//list = new ArrayList<>();

			list.clear();
		}
		else
		{
			int j = list.size() - 1;

			// find smallest entry greater than list.get(i) from suffix
			while(j > i && list.get(j) < list.get(i))
			{
				j--;
			}
		
			// swap entry i and j
			int temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);

			// reverse suffix to obtain smallest permutation
			int start = i + 1;
			int end = list.size() - 1;
		
			while(start < end)
			{
				temp = list.get(start);
				list.set(start, list.get(end));
				list.set(end, temp);
				start++;
				end--;
			}
		}
	}
}
