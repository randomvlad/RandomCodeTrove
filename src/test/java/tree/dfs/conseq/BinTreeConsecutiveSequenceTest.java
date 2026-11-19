package tree.dfs.conseq;

import org.junit.jupiter.api.Test;
import tree.dfs.conseq.BinTreeConsecutiveSequence.Node;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

class BinTreeConsecutiveSequenceTest {

    @Test
    void findLongestConsecutiveSequence_Input1_Longest3() {
        // Given
        Node<Integer> root = buildTree("1 3 2 x x x 2 x 3 x x");

        // When
        int actualLongest = new BinTreeConsecutiveSequence().findLongestConsecutiveSequence(root);

        // Then
        assertThat(actualLongest).isEqualTo(3); // 1 → 2  → 3
    }

    @Test
    void findLongestConsecutiveSequence_Input2_Longest4() {
        // Given
        Node<Integer> root = buildTree("0 -1 -2 x x x 1 2 3 x x x x");

        // When
        int actualLongest = new BinTreeConsecutiveSequence().findLongestConsecutiveSequence(root);

        // Then
        assertThat(actualLongest).isEqualTo(4); // 0 → 1 → 2 → 3
    }

    @Test
    void findLongestConsecutiveSequence_NullRoot_ZeroLongest() {
        // Given
        Node<Integer> root = null;

        // When
        int actualLongest = new BinTreeConsecutiveSequence().findLongestConsecutiveSequence(root);

        // Then
        assertThat(actualLongest).isEqualTo(0);
    }

    @Test
    void findLongestConsecutiveSequence_Input3_Longest0() {
        // Given
        Node<Integer> root = buildTree("5 x 4 x x");

        // When
        int actualLongest = new BinTreeConsecutiveSequence().findLongestConsecutiveSequence(root);

        // Then
        assertThat(actualLongest).isEqualTo(1);
    }

    private Node<Integer> buildTree(String input) {
        List<String> nodes = List.of(input.split(" "));
        return buildTree(nodes.iterator(), Integer::parseInt);
    }

    private <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) {
            return null;
        }
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<>(f.apply(val), left, right);
    }
}
