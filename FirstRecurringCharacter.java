import java.util.*;

public class FirstRecurringCharacter {
    public static void main(String[] args)
    {
        Character character = firstRecurringCharacter("abcabc"); // should return a

        System.out.println(character);
    }

    public static Character firstRecurringCharacter(String input)
    {
        Set<Character> set = new HashSet<>();
        char[] array = input.toCharArray();

        for(char a : array)
        {
            if(!set.contains(a))
            {
                set.add(a);
            }
            else
            {
                return a;
            }
        }

        return null;
    }
}
