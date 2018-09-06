/* qs 5.2 - variant */

public class AddTwoBitStrings
{
	public static void main(String[] args)
	{
		String a = "1111";
		String b = "1110";
		String result = addBitStrings(a, b);
		System.out.println(result);
	}

	public static String addBitStrings(String a, String b)
	{
		int i = a.length() - 1;
		int j = b.length() - 1;
		int sum = 0;
		StringBuilder result = new StringBuilder();

		// sum == 1 - there is still carry-out	
		while(i >= 0 || j >= 0 || sum == 1)
		{
		
			// - '0' to turn char into int from 0 - 9
			sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
			sum += ((j >= 0) ? b.charAt(j) - '0' : 0);

			//result = (sum % 2) + result;

			// insert at 0 works like prepend but requires O(n^2)
			result.insert(0,sum%2);
			
			// turning sum into carry-out
			sum = sum / 2;
 			
			i--;
			j--;
		}

		return result.toString();	
	}	
}
  
