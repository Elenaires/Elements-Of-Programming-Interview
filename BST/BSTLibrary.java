import java.util.*;

public class BSTLibrary
{
	public static void main(String[] args)
	{
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(10);
		set.add(4);
		set.add(80);
		set.add(2);
		
		System.out.println("largest value is " + set.last());

		System.out.println("element greater than 4 is " + set.higher(4));

		System.out.println(set);
	}
}
