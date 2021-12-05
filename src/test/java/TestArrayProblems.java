import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestArrayProblems {

    @Test
    public void testMissingNumberInArray() {

        ArrayProblems arrayProblems = new ArrayProblems();
        // one missing number
        ArrayProblems.printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        ArrayProblems.printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        ArrayProblems.printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        ArrayProblems.printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = ArrayProblems.getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d ", Arrays.toString(iArray), missing);
    }

}
