public class HashTable {

    static private class ListNode {
        Object key;
        Object value;
        ListNode next;  // Pointer to the next node in the list - null marks end of list
    }

    private ListNode[] table; // The Hashtable, represented by an array of LinkedLists

    private int count; // The number of (key,value) pairs in the hashtable

    public HashTable(int initialSize) {
        table = new ListNode[initialSize];
    }

    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    public int size() {
        return count;
    }

    public void put(Object key, Object value) {

        int bucket = hash(key);                 // Which location should this key be in ?
        ListNode list = table[bucket];          // Node for traversing the linked list at this location

        // search the nodes in the list to see if the key already exists
        while (list!=null) {
            if(list.key.equals(key)) {
                break;
            }
            list = list.next;
        }

        // At this point either the list is null or list.key.equals(key)
        if(list != null) {
            // We have found the key so just change the associated value
            list.value = value;
        }
        else {
            // List is null so key is not already in the list. Add a new node to contain the new key and value
            // First make sure table is big enough.
            if(count >= 0.75 * table.length) {
                resize();
            }

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];

            table[bucket] = newNode;    // Add the new Node to the HashTable
            count++;                    // count the newly added key
        }
    }

    public Object get(Object key) {

        // Retrieve the value associated with the specified key in the table if any, if not return null
        int bucket = hash(key);                 // Which location should this key be in ?
        ListNode list = table[bucket];          // Node for traversing the linked list at this location

        while(list != null) {
            // Check if specified key is in the node that list points to and if so return the associated value
            if (list.key.equals(key))
                return list.value;

            list = list.next;       // Move onto the next node in the list
        }

        // If we get to this point we have looked at every node in the list without finding the key => Key is not in table
        return null;
    }

    public void remove(Object key) {
        // Remove the key and its associated value from the table, if the key occurs in the table.  If it does not occur, then do nothing.

        int bucket = hash(key);                 // At what location should the key be?
        if (table[bucket] == null) {
            // There are no keys in that location, so key does not occur in the table.  There is nothing to do, so return.
            return;
        }
        if (table[bucket].key.equals(key)) {
            // If the key is the first node on the list, then table[bucket] must be changed to eliminate the first node from the list.
            table[bucket] = table[bucket].next;
            count--; // Remove new number of items in the table.
            return;
        }
        // We have to remove a node from somewhere in the middle of the list, or at the end.
        // Use a pointer to traverse the list, looking for a node that contains the specified key, and remove if it is found.
        ListNode prev = table[bucket];      // The node that precedes curr in the list.  Prev.next is always equal to curr.
        ListNode curr = prev.next;          // For traversing the list, starting from the second node.
        while (curr != null && ! curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }
        // If we get to this point, then either curr is null, or curr.key is equal to key. In the later case, we have to remove curr from the list.
        // Do this by making prev.next point to the node after curr, instead of to curr.  If curr is null, it means that the key was not found in the table.
        if (curr != null) {
            prev.next = curr.next;
            count--;  // Record new number of items in the table.
        }
    }



    /** Utility Methods **/

    public boolean containsKey(Object key) {
        // Test whether the specified key has an associated value in the table.

        int bucket = hash(key);             // In what location should key be?
        ListNode list = table[bucket];      // For traversing the list.
        while (list != null) {
            // If we find the key in this node, return true.
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
        // If we get to this point, we know that the key does not exist in the table.
        return false;
    }

    private void resize() {
        // Double the size of the table, and redistribute the key/value pairs to their proper locations in the new table.
        ListNode[] newtable = new ListNode[table.length*2];
        for (int i = 0; i < table.length; i++) {
            // Move all the nodes in linked list number i into the new table.  No new ListNodes are created.
            // The existing ListNode for each key/value pair is moved to the newtable.
            // This is done by changing the "next" pointer in the node and by making a pointer in the new table point to the node.
            ListNode list = table[i]; // For traversing linked list number i.
            while (list != null) {
                // Move the node pointed to by list to the new table.
                ListNode next = list.next;  // The is the next node in the list.
                // Remember it, before changing the value of list!
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                // hash is the hash code of list.key that is appropriate for the new table size.  The next two lines add
                // the node pointed to by list onto the head of the linked list in the new table at position number hash.
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;  // Move on to the next node in the OLD table.
            }
        }
        table = newtable;  // Replace the table with the new table.
    } // end resize()

    void dump() {
        // This method is NOT part of the usual interface for a hash table. It is here only to be used for testing purposes, and
        // should be removed before the class is released for general use. This lists the (key,value) pairs in each location of the table.
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            // Print out the location number and the list of key/value pairs in this location.
            System.out.print(i + ":");
            ListNode list = table[i]; // For traversing linked list number i.
            while (list != null) {
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
            }
            System.out.println();
        }
    } // end dump()


}
