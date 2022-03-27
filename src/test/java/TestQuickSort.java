import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import java.util.Arrays;

@Slf4j
public class TestQuickSort {

    @Test
    public void testQuicksort() {

        int[] array = {5,4,3,2,1};
        int[] expected ={1,2,3,4,5};

        int[] sorted = QuickSort.quickSort(array, 0, array.length-1);
        log.info(Arrays.toString(sorted));
        assertArrayEquals(sorted, expected);
    }
}
