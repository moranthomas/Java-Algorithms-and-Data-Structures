import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Note that I start with a really small table so that I can easily test the resize() method.
 * */

public class TestHashTable {

    @Test
    public void testHashTable(){

        HashTable table = new HashTable(2);
        String key,value;

        /** This version requires access to the console.....
        // while (true) {
            System.out.println("\nMenu:");
            System.out.println("   1. test put(key,value)");
            System.out.println("   2. test get(key)");
            System.out.println("   3. test containsKey(key)");
            System.out.println("   4. test remove(key)");
            System.out.println("   5. show complete contents of hash table.");
            System.out.println("   6. EXIT");
            System.out.print("Enter your command:  ");

            /*Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            */

            //Hardcode for Unit Testing Purposes - avoid needing access to console in
            int choice = 1;
            key = "Jude";
            value = "23 The Forum, Inglewood, Los Angeles";

            switch ( choice) {
                case 1:
                    System.out.print("\n   Key = " + key);
                    //key = scanner.nextLine();
                    System.out.print("   Value = " + value);
                    //value = scanner.nextLine();
                    table.put(key,value);
                    break;
                case 2:
                    System.out.print("\n   Key = ");
                    //key = scanner.nextLine();
                    System.out.println("   Value is " + table.get(key));
                    break;
                case 3:
                    System.out.print("\n   Key = ");
                    //key = scanner.nextLine();
                    System.out.println("   containsKey(" + key + ") is "
                            + table.containsKey(key));
                    break;
                case 4:
                    System.out.print("\n   Key = ");
                    //key = scanner.nextLine();
                    table.remove(key);
                    break;
                case 5:
                    table.dump();
                    break;
                case 6:
                    return;  // End program by returning from main()
                default:
                    System.out.println("   Illegal command.");
                    break;
            }
            System.out.println("\nHash table size is " + table.size());
        }
    //}

} // end class TestHashTable