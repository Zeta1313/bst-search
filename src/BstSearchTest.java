import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BstSearchTest {
    @Test
    void ThrowsException() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        assertThrows(NullPointerException.class, () -> {
            BstSearch.contains(root, null);
        });
    }

    @Test
    void ReturnsFalseRootNull() {
        assertFalse(BstSearch.contains(null, 5));
    }

    @Test
    void ReturnsTrueTargetRoot() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        assertTrue(BstSearch.contains(root, 10));
    }

    @Test
    void ReturnsTrueTargetIsSubtree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);

        assertTrue(BstSearch.contains(root, 5));
    }

    @Test
    void ReturnsFalseTargetNotPresent() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);

        assertFalse(BstSearch.contains(root, 20));
    }

    @Test
    void ReturnsTrueLargeTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);
        root.right.right = new BinaryTreeNode<>(20);
        root.right.left = new BinaryTreeNode<>(10);
        root.right.right.right = new BinaryTreeNode<>(25);
        root.right.right.right.left = new BinaryTreeNode<>(23);

        assertTrue(BstSearch.contains(root, 23));
    }

    @Test
    void ReturnsTrueLargeTreeStrings() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("four");
        root.left = new BinaryTreeNode<>("three");
        root.right = new BinaryTreeNode<>("six");
        root.right.right = new BinaryTreeNode<>("seven");
        root.right.left = new BinaryTreeNode<>("five");
        root.right.right.right = new BinaryTreeNode<>("nine");
        root.right.right.right.left = new BinaryTreeNode<>("eight");

        assertTrue(BstSearch.contains(root, "eight"));
    }

    @Test
    void ReturnsFalseLargeTreeStrings() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("four");
        root.left = new BinaryTreeNode<>("three");
        root.left.left = new BinaryTreeNode<String>("one");
        root.right = new BinaryTreeNode<>("six");
        root.right.right = new BinaryTreeNode<>("seven");
        root.right.left = new BinaryTreeNode<>("five");
        root.right.right.right = new BinaryTreeNode<>("nine");
        root.right.right.right.left = new BinaryTreeNode<>("eight");

        assertFalse(BstSearch.contains(root, "eleven"));
    }
}
