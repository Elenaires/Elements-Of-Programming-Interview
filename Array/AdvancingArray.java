/* qs 5.4 */

public class AdvancingArray
{
	public static void main(String[] args)
	{
		int[] array = new int[]{3,2,0,0,2,0,1};
		boolean canReach = canReachEnd(array);

		System.out.println(canReach);
	}

	public static boolean canReachEnd(int[] array)
	{
		int maxSteps = 0;
		int i = 0;

		while(i <= maxSteps && maxSteps < array.length-1)
		{
			maxSteps = Math.max(maxSteps, array[i] + i);
			i++;
		}

		return maxSteps >= array.length - 1;
	}
}
