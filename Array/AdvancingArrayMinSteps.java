/* qs 5.4 variant */
/* for example A = {2,3,1,2,5,3,1}
* i = 1, max(2, 1+3) = 4, step = 3, jump = 1
* i = 2, max(4, 2+1) = 4, step = 2, jump = 1
* i = 3, max(4, 3+2) = 5, step = 1, jump = 1
* i = 4, max(5, 4+5) = 9, step = 5, jump = 2
* since furthestReachSoFar(9) > A.length - 1 (6), while loop terminated
* jump = minStep = 2
*/

// linear time - tushar roy has a solution that uses dynamic programming

public class AdvancingArrayMinSteps
{
	public static void main(String[] args)
	{
		int[] array = new int[]{1,3,5,8,9,2,6,7,6,8,9};
		int minStep = calcMinSteps(array);
		
		System.out.println(minStep);
	}

	public static int calcMinSteps(int[] array)
	{
		// slight variant from qs 5.4
		// we start from i = 1, preset furthestReachSoFar and minStep
		int furthestReachSoFar = array[0];
		int i = 1;
		int jump = 1;
		int step = array[0];
		
		while(i <= furthestReachSoFar && furthestReachSoFar < array.length - 1)
		{
			furthestReachSoFar = Math.max(furthestReachSoFar, array[i] + i);
			i++;
			
			step--;
			if(step == 0)
			{
				jump++;
	
				// important!!
				// after we exhaust the steps from previous index
				// we update step to num steps needed to reach furthestReach
				// remember furthestReach is calculated 
				// based on index + array[index]
				// for example A = {2,4,1,1,0,2,3}, 2->4, 4->2, 2->end
				// our algorithm assumes 2->1(index 2), exhausted 2 steps
				// but at that position, furthestReach is still 5 from
				// previous index (4+1)
				// thus step is updated to 5 - current index (2) = 3
				// now we are back to exhausting steps from 4 (index 1)
				step = furthestReachSoFar - i;
			}
		}

		// cannnot reach end of array
		if(furthestReachSoFar < array.length - 1)
		{
			jump = -1;
		}

		return jump;
	}
}
		
