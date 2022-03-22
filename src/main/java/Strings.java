import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    /** 2 - REVERSE A SENTENCE FULLY */
    public String reverseSentence(String INPUTSTRING) {

        final String WHITESPACE = " ";
        String reversed;

        // METHOD 1 - Use StringBuilder to reverse only the words first
        String[] words = INPUTSTRING.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }
        reversed = reversedString.toString();


        // METHOD 2 - Use Stringbuilder same as above but incorporating Java 8 streams and lambas:
        final Pattern PATTERN = Pattern.compile(" +");
        reversed = PATTERN.splitAsStream(INPUTSTRING)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));

        System.out.println("The reversed words in the same string order is : " + reversed);

        return reversed;
    }

    /** 3 - REVERSE EACH OF THE WORDS IN A SENTENCE (BUT NOT THE SENTENCE) */
    public String reverseSentenceAndWords(String INPUTSTRING) {
        // Reverse the letters of each word and the words themselves (Doesn't reverse the Sentence)
        StringBuilder revStr = new StringBuilder(INPUTSTRING).reverse();   // Use the built-in StringBuilder.reverse() method
        return revStr.toString();
    }


    /** CHECK STRINGS FOR ANAGRAMS */
    public String checkForAnagrams(String a, String b) {

        // Write your code here
        int minNoOfDeletions = 0;

        // a.substring(b) (in any order but same length and frequency ) must be non null
        int[] a_frequencies = new int [26];
        int[] b_frequencies = new int [26];

        for (int i =0; i< a.length(); i++) {
            char currenChar = a.charAt(i);
            int charToInt = (int)currenChar;
            int position = charToInt - (int)'a';
            a_frequencies[position]++;
        }

        for (int i =0; i< b.length(); i++) {
            char currenChar = b.charAt(i);
            int charToInt = (int)currenChar;
            int position = charToInt - (int)'a';
            b_frequencies[position]++;
        }

        for (int i=0; i < 26; i++) {
            int diff = Math.abs(a_frequencies[i] - b_frequencies[i] );
            minNoOfDeletions += diff;
        }

        System.out.println(minNoOfDeletions);

        if(minNoOfDeletions == 0) {
           return "isAnagram";
        }
        else {
            return "isNOTAnagram";
        }

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


    String checkSubstringsUsingSortedTreeSet(String str, int k) {
        SortedSet<String> sets=new TreeSet<String>();
        for(int i=0; i<=str.length()-k; i++){
            sets.add(str.substring(i, i+k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());

        return sets.first();
    }

    String checkSubstringsUsingInlineVariables(String str, int k) {
        String max=str.substring(0,k);
        String min=str.substring(0,k);

        for(int i=0; i+k<=str.length(); i++){

            String substring = str.substring(i, i + k);

            if(substring.compareTo(min)<0) min = substring;
            if(substring.compareTo(max)>0) max = substring;
        }

        System.out.println(min);
        System.out.println(max);

        return max;
    }


}
