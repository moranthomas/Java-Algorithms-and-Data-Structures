public class ReverseLinkedList<T> {

    private Node head; // Head is the first node in linked list

    private static class Node<T> {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public void append(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }

    private Node tail() {
        Node tail = head;
        // Find last element of linked list known as tail
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current).append("-->");
            current = current.next;
        }
        if ( sb.length() >=3){
            sb.delete(sb.length() - 3, sb.length());

            // to remove --> from last node
        }
            return sb.toString();
    }

        /** Reverse linked list using 3 pointers approach in O(n) time It basically creates a new
         list by reversing direction and iteratively inserting the last element at the start of the list. */

        public void reverseIteratively () {
            Node current = head;
            Node previous = null;
            Node forward = null;
            // traversing linked list until there is no more element
            while(current.next != null){
                // Saving reference of next node, since we are changing current node
                forward = current.next;
                // Inserting node at start of new list
                current.next = previous;
                previous = current;
                // Advancing to next node
                current = forward;
            }
            head = current;
            head.next = previous;
        }

        /** Reverse a singly linked list using recursion. In recursion Stack is used to store data.
         Traverse linked list till we find the tail, that would be new head for reversed linked list. */
        private Node reverseRecursively(Node node) {
            Node newHead; //base case - tail of original linked list
            if((node.next == null))
             {
                 return node;
             }
            newHead = reverseRecursively(node.next);
            // reverse the link e.g. C->D->null will be null
            node.next.next = node;
            node.next = null;
            return newHead;
        }

}