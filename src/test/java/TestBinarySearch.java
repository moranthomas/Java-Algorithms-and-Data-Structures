import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestBinarySearch {

    int[] array;
    BinarySearch binarySearch = new BinarySearch();

    @BeforeEach
    void setUp() {
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void testBSIteratively() {
        int index = binarySearch.runBinarySearchIteratively(array, 4, 0, array.length-1);
        if(index > 0) {
            log.info("key found using ITERATION at position: " + index);
        }
        else {
            log.info("key not found :( ");
        }
    }

    @Test
    public void testBSRecursively() {
        int index = binarySearch.runBinarySearchRecursively(array, 4, 0, array.length-1);
        if(index > 0) {
            log.info("key found using RECURSION at position: " + index);
        }
        else {
            log.info("key not found using RECURSION :( ");
        }
    }


}
