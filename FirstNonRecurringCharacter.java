import java.util.*;

public class FirstNonRecurringCharacter {

    public static void main(String[] args)
    {
        Character character = firstNonRecurringCharacter("abc"); // should return null
        System.out.println(character);
    }

    public static Character firstNonRecurringCharacter(String input)
    {
        Set<Character> set = new LinkedHashSet<>();

        char[] array = input.toCharArray();

        for(char a : array)
        {
            if(!set.contains(a))
            {
                set.add(a);
            }
            else
            {
                set.remove(a);
            }
        }

        Character character = null;

        if(!set.isEmpty())
        {
            character = set.iterator().next();
        }

        return character;

    }

}

