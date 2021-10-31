import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class TestLinkedLists {

    @Test
    public void  removeDuplicates() {
        // Write your code here

        SinglyLinkedListNode linkedList = new SinglyLinkedListNode(10);
        linkedList.push(20);
        linkedList.push(13);
        linkedList.push(13);
        linkedList.push(11);
        linkedList.push(11);
        linkedList.push(11);

        SinglyLinkedListNode modifiedLList = linkedList.RemoveDuplicates(linkedList);
        log.info(Arrays.toString(modifiedLList.toArray()));

    }

}
