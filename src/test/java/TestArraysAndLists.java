import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class TestArraysAndLists {

    static List<Integer> intList;

    @BeforeAll
    public static void init() {
        // Create a new list of Integers and initialize
        intList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
    }



    @Test
    public void testMissingNumberInArray() {

        ArraysAndLists arraysAndLists = new ArraysAndLists();
        // one missing number
        arraysAndLists.printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);

        // two missing number
        arraysAndLists.printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

        // three missing number
        arraysAndLists.printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

        // four missing number
        arraysAndLists.printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = arraysAndLists.getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d ", Arrays.toString(iArray), missing);
    }

    @Test
    public void simpleArraySum() {
        int sum = 0;
        for( int x : intList) {
            sum = sum +x;
        }
        System.out.println(sum);
    }

    @Test
    public void printAllAvailableZoneIds() {

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        // Iterate Set Using For-Each Loop (also called the Enhanced For-Loop)
        for(String str : allZoneIds) {
            log.info(str);
        }
        // Iterate Set Using the Java Stream API
        Stream<String> stream = allZoneIds.stream();
        stream.forEach((element) -> { log.info(element); });

        List<Integer> sortedList = intList.stream().sorted().collect(Collectors.toList());
    }

    @Test
    public void iteratingAList() {
        // Iterating a list using an Iterator
        List<String> arraylist = new ArrayList<>();
        //adds at the end of list
        arraylist.add("Sachin");                            //[Sachin]
        //adds at the end of list
        arraylist.add("Dravid");                            //[Sachin, Dravid]
        //adds at the index 0
        arraylist.add(0, "Ganguly");          //[Ganguly, Sachin, Dravid]
        //List allows duplicates - Sachin is present in the list twice
        arraylist.add("Sachin");                            //[ Ganguly, Sachin, Dravid, Sachin]

        System.out.println(arraylist.size());   //4

        Iterator<String> arraylistIterator = arraylist.iterator();
        while (arraylistIterator.hasNext()) {
            String str = arraylistIterator.next();
            System.out.println(str);                    //Prints the 4 names in the list on separate lines.
        }

        assert(arraylist.contains("Dravid"));
    }

    @Test
    public void testIntstreamToHashMap() {
        HashMap myMap = new HashMap();
        myMap = (HashMap) intList.stream()
                .filter(x -> x%2 == 0)
                .collect(Collectors.toMap(x -> 0, x -> 1));   // TODO - incomplete
    }


    @Test
    public void testPairedSocksInList() {

        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));

        // Loop through the list and compare each element with all the others and count, then modulo 2

        Set<Integer> set = new HashSet<Integer>();
        int pairCount = 0;

        for(int i=0; i<intList.size(); i++) {
            int element = intList.get(i);
            if(set.contains(element)) {
                set.remove(element);
                pairCount++;
            }
            else {
                set.add(element);
            }
        }
        System.out.println("The number of pairs in the list is : " + pairCount);

//        System.out.println("The number of pairs in the list is : " +
//        intList.stream()
//            .filter(x-> x%2==0)
//            .count());
    }


    @Test
    public void testIntStream() {

        // Create a new list of Integers and initialize
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));

        // Print out the list of all the numbers squared
        System.out.println("The list of numbers squared: ");
        list.stream().map(x -> x * x)
                .forEach(System.out::println);

        // Create an array from this List (Optional Step)
        int[] intArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }
        // You can then call all the same operators on the stream as if you went straight to list

        // Two ways of creating an IntStream from this array:

        // 1. Arrays.stream -> IntStream
        System.out.println("\n The list of numbers that are exactly divisible by two: ");
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.filter(x-> x%2==0)
                .forEach(System.out::println);

        // 2. Stream.of -> Stream<int[]>
        //  Stream<int[]> temp = Stream.of(intArray);
        //
        //  // Cant print Stream<int[]> directly, convert / flat it to IntStream
        //  IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        //  intStream2.forEach(x -> System.out.println(x));
    }

    @Test
    public void testStringStreamFromArray() {

        String[] array = {"a", "b", "c", "d", "e"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));

    }
}
