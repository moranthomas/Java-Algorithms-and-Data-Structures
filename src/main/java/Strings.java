import java.util.HashSet;
import java.util.Set;

public class Strings {


    /** 1 - REVERSE A STRING */
    // The Traditional for Loop (in place)
    public String reverseString(String input) {

        String reversed = "";
        if (input == null) {
            return input;
        }
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return reversed;
    }


    /** COMPARING SUBSTRINGS */
    // The Traditional for Loop (in place)
    public String compareTwoSubStringsBrute(String s1, String s2) {

        // Given 2 strings, check if they share a common substring. A substring may be as small as one character.
        String commonSubstring = "NO";

        if (s1.contains(s2)) {
            commonSubstring = "YES";
        }

        int s1Len = s1.length();
        int s2Len = s2.length();

        int shortestStringLength = s1Len > s2Len ? s2Len : s1Len;

        // Loop through each character in s1 and see if
        for (int i = 0; i < shortestStringLength; i++) {
            if (s1.contains(s2.substring(i, i + 1))) {
                commonSubstring = "YES";
            }
        }
        return commonSubstring;
    }

    // Efficient method using HashSets
    public String compareTwoSubStringsEfficient(String s1, String s2) {

        // Given two strings, determine if they share a common substring.
        // A substring may be as small as one character.
        String commonSubstring = "NO";

        Set<Character> s1Set = new HashSet<Character>();
        Set<Character> s2Set = new HashSet<Character>();

        for(char c : s1.toCharArray()) { s1Set.add(c); }
        for(char c : s2.toCharArray()) { s2Set.add(c); }

        // store intersection of both in s1Set
        s1Set.retainAll(s2Set);

        if(!s1Set.isEmpty()) {
            commonSubstring = "YES";
        }

       return commonSubstring;
    }


}
