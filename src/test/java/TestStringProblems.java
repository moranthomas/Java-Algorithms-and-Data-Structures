import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

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
        final String INPUTSTRING = "The brown fox jumped over the lazy dog";
        log.info("The reversed sentence : " + strings.reverseSentence(INPUTSTRING));
    }

    @Test
    public void testReversingASentenceAndWords() {
        final String INPUTSTRING = "The brown fox jumped over the lazy dog";
        log.info("The reversed words and the words themselves reversed is : " + strings.reverseSentenceAndWords(INPUTSTRING));
    }

    @Test
    public void testCompareTwoSubStringsBrute() {
        String s1 = "I am a very lazy wicked man";
        String s2 = "wicked";
        String s3 = "x";

        log.info(strings.compareTwoSubStringsBrute(s1, s2));
        log.info(strings.compareTwoSubStringsBrute(s1, s3));
    }

    @Test
    public void testCompareTwoSubStringsEfficient() {

        String s1 = "I am a very lazy wicked man";
        String s2 = "wicked";
        String s3 = "x";

        log.info(strings.compareTwoSubStringsEfficient(s1, s2));
        log.info(strings.compareTwoSubStringsEfficient(s1, s3));
    }


    @Test
    public void checkAnagram() {
        String a = "cat";
        String b = "abacats";
        log.info(strings.checkForAnagrams(a, b));
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

}
