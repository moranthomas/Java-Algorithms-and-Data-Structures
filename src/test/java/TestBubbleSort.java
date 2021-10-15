import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class TestBubbleSort {

    @Test
    public void testBubbles() {
        int[] array = {5,4,3,2,1};

        int[] sortedArray = BubbleSort.sort(array);
        log.info(Arrays.toString(sortedArray));
    }
}
