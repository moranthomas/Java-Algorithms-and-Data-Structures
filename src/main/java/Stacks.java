import org.junit.Test;

import java.util.Stack;

public class Stacks {

    @Test
    public void testCountingValleys() {

        String path = "DDUUUUDD";
        int steps = 8;

        int valleyCount = 0;
        Stack<Integer> stack = new Stack<>();

        // start means you have had at least one valley
        boolean start = false;
        for(int i=0; i < path.length(); i++) {
            if(path.charAt(i)=='D') {
                start = true;
                stack.push(1);
            }
            else if(start && path.charAt(i) == 'U') {
                stack.pop();
                if(stack.size() == 0) {
                    valleyCount++;
                    start = false;
                }
            }
        }
        System.out.println(valleyCount);
    }
}
