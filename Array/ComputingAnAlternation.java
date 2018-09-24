/* qs 5.8 */

public class ComputingAnAlternation
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{5,4,6,4,2,1,4,8};
		computingAnAlternation(arr);
	
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	public static void computingAnAlternation(int[] arr)
	{
		for(int i = 1; i < arr.length; i++)
		{
			if(i % 2 == 0 && arr[i-1] < arr[i] || i % 2 != 0 && arr[i-1] > arr[i])
			{
				int temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
			}
		}
	}
}
