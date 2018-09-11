/* qs 5.4 variant - dynamic programming */

public class AdvancingArrayMinStepsDP
{
	public static void main(String[] args)
	{
		int[] array = new int[]{2,3,1,1,2,4,2,0,1,1};
		System.out.println(minStepsDP(array));
	}

	public static int minStepsDP(int[] array)
	{
		int[] jumps = new int[array.length];
		jumps[0] = 0;

		// this array is used to track shortest path - not used in this qs
		int[] parent = new int[array.length];
		parent[0] = -1;

		for(int i = 1; i < array.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				// if we can go to i from j within those steps in array
				if(j + array[j] >= i)
				{
					int temp = 1 + jumps[j];
		
					jumps[i] = Math.min(jumps[i], jumps[j]+1);

					if(jumps[i] == 0)
					{
						jumps[i] = temp;
						parent[i] = j;
					}
					else if(temp < jumps[i])
					{
						jumps[i] = temp;
						parent[i] = j;
					}	
					// if temp is >= jumps[i] we do nothing 
				}	
			}

			// quick dirty way to terminate loop if it's impossible to reach
			// end of array :P
			if(jumps[i] == 0)
			{
				return -1;
			}
		}

		return jumps[jumps.length-1];
	}
}
