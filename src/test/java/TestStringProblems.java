import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        String reversed = strings.reverseString("cat");
        String reversedNull = strings.reverseString(null);
        String reversedEmpty = strings.reverseString(StringUtils.EMPTY);

        assertEquals("tac", reversed);
        assertEquals(null, reversedNull);
        assertEquals(StringUtils.EMPTY, reversedEmpty);
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
        String c = "tac";
        log.info("Are these anagrams ? : " + String.valueOf(strings.checkForAnagrams(a, b)));
        log.info("Are these anagrams ? : " + String.valueOf(strings.checkForAnagrams(a, c)));
    }


    @Test
    public void testSmallestAndLargestSubstrings() {

        /*Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length . */
        String str = "welcometojava";
        int k = 3;

        strings.checkSubstringsUsingSortedTreeSet(str, k);      // Using Sorted Treeset
        strings.checkSubstringsUsingInlineVariables(str, k);      // Using inline variables

    }


}
