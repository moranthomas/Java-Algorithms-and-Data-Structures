import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queues {

    @Test
    public void testLeftRotationOfArrayUsingQueues() {

        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        int d = 4;      //number of left rotations (shifts) to perform
        // e.g. [1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,2,1] -> [4,5,1,2,3] -> [5,1,2,3,4]
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        Iterator iterator = a.iterator();
        while(iterator.hasNext()) {
            queue.add((Integer) iterator.next());
        }
        System.out.println("Initial Queue: " + queue);

        for(int i = 0; i < d; i++) {
            int top = queue.remove();
            queue.add(top);
            System.out.println(queue);
        }

        System.out.println("Final Queue: " + queue);
        List l = new ArrayList(queue);

    }
}
