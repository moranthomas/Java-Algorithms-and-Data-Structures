import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class TestStringProblems {

    static Strings strings;

    @BeforeAll
    public static void setUp() {
         strings = new Strings();   // not working ?
    }

    @Test
    public void testReversingWordIteratively() {
        //The Traditional for Loop (in place)
        String inputStr = "abracadabra";
        log.info("Reversed String (Iteratively) = " + strings.reverseString(inputStr));
    }


    @Test
    public void testReversingASentence() {

        final String WHITESPACE = " ";
        final String INPUTSTRING = "The brown fox jumped over the lazy dog";
        String reversed;

        // METHOD 1 - Use StringBuilder to reverse only the words first
        String[] words = INPUTSTRING.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word: words) {
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


        // METHOD 3 - Reverse the letters of each word and the words themselves (Doesn't reverse the Sentence)
        StringBuilder revStr =  new StringBuilder(INPUTSTRING).reverse();   // Use the built-in StringBuilder.reverse() method
        System.out.println("The reversed words and the words themselves reversed is : " + revStr);


    }

    @Test
    public void makeAnagram() {

        String a = "cat";
        String b = "abacats";

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
        //return minNoOfDeletions;

    }


    @Test
    public void testSmallestAndLargestSubstrings() {

        /*Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length . */
        String str = "welcometojava";
        int k = 3;

        solution1UsingSortedTreeSet(str, k);      // Using Sorted Treeset
        solution2UsingInlineVariables(str, k);      // Using inline variables

    }

    void solution1UsingSortedTreeSet(String str, int k) {
        SortedSet<String> sets=new TreeSet<String>();
        for(int i=0; i<=str.length()-k; i++){
            sets.add(str.substring(i, i+k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());
    }

    void solution2UsingInlineVariables(String str, int k) {
        String max=str.substring(0,k);
        String min=str.substring(0,k);

        for(int i=0; i+k<=str.length(); i++){

            String substring = str.substring(i, i + k);

            if(substring.compareTo(min)<0) min = substring;
            if(substring.compareTo(max)>0) max = substring;
        }

        System.out.println(min);
        System.out.println(max);
    }




    @Test
    public void compareTwoSubStringsBrute() {
        String s1 = "I am a very lazy wicked man";
        String s2 = "wicked";
        String s3 = "x";

        log.info(strings.compareTwoSubStringsBrute(s1, s2));
        log.info(strings.compareTwoSubStringsBrute(s1, s3));
    }

    @Test
    public void compareTwoSubStringsEfficient() {

        String s1 = "I am a very lazy wicked man";
        String s2 = "wicked";
        String s3 = "x";

        log.info(strings.compareTwoSubStringsEfficient(s1, s2));
        log.info(strings.compareTwoSubStringsEfficient(s1, s3));

    }
}
