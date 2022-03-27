import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchTree {

    Node root;

    class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    // constructor
    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    /** Function to check if binary tree is empty or not. Time Complexity of this solution is constant O(1)
     * for best, average and worst case. @return true if binary search tree is empty */
    public boolean isEmpty() {
        return null == root;
    }

    /** * Java function to clear the binary search tree. Time complexity of this method is O(1) */
    public void clear() {
        root = null;
    }

    // sometimes also called 'visit()'
    private void printValue(int value) {
        System.out.print(" " + value);
    }

    public void add(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }
        if (value < current.data) {
            // go left
            current.left = insertRecursive(current.left, value);
        } else if (value > current.data) {
            // go right
            current.right = insertRecursive(current.right, value);
        }
        return current;
    }


    public boolean contains(Node current, int value) {
        if (value == current.data) {
            return true;
        } else if (value < current.data) {
            // go left
            if (current.left == null) {
                return false;
            } else {
                return contains(current.left, value);
            }
        } else {
            //go right
            if (current.right == null) {
                return false;
            } else {
                return contains(current.right, value);
            }
        }
    }

    public void printInOrder(Node node) {
        if(node !=null) {
            printInOrder(node.left);
            printValue(node.data);
            printInOrder(node.right);
        }
    }
}



