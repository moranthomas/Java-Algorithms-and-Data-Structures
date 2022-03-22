import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class TestBinarySearchTree {

    BinarySearchTree bst = new BinarySearchTree();

    @BeforeEach
    private void plantATree() {
        bst.add(9);
        bst.add(8);
        bst.add(7);
        bst.add(6);
        bst.add(5);
        bst.add(4);
        bst.add(3);
    }

    @Test
    public void testInorderTraversal() {
        bst.printInOrder(bst.root);
    }

    @Test
    public void testTreeContainsValue() {
        log.info("Does tree contain the value 4 ? " + bst.contains(bst.root, 4));
    }

}