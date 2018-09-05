/* qs 5.1 - variant d
* reorder boolean array so that false keys appear first
* but keep relative ordering of true keys
* O(1) space and O(n) time
*/

public class ReorderBooleanArrayVariant
{
	public static void main(String[] args)
	{
		boolean[] arr = new boolean[]{true,false, false, true, true, false, true, false};
	
		reorderArray(arr);

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	public static void reorderArray(boolean[] arr)
	{
		int end = arr.length - 1;

		for(int i = arr.length - 1; i >= 0; i--)
		{
			if(arr[i])
			{
				if(i != end)
				{
					boolean temp = arr[end];
					arr[end] = arr[i];
					arr[i] = temp;
				}
				end--;
			}
		}
	}
}
