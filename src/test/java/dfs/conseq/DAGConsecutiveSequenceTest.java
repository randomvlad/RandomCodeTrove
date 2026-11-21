package dfs.conseq;

import static org.assertj.core.api.Assertions.assertThat;

import dfs.conseq.DAGConsecutiveSequence.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

class DAGConsecutiveSequenceTest {

    @Test
    void findLongestConsecutive_SiblingWithNextValue_Longest2() {
        // Given
        List<Node> graph = GraphHelper.build("1->2 1->3 2->9");

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(2); // 1 → 2 (3 is a sibling of 2, not its child)
    }

    @Test
    void findLongestConsecutive_SiblingsWithSameValue_Longest3() {
        // Given
        List<Node> graph = GraphHelper.build("1->2a->7 1->2b->3");

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(3); // 1 → 2b → 3
    }

    @Test
    void findLongestConsecutive_SameValueSiblingWithoutChildrenFirst_Longest3() {
        // Given
        List<Node> graph = GraphHelper.build("1->2a 1->2b->3");

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(3); // 1 → 2b → 3
    }

    @Test
    void findLongestConsecutive_DiamondWithSharedNode_Longest4() {
        // Given
        List<Node> graph = GraphHelper.build("1->2a->3 1->2b->3 3->4");

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(4); // 1 → 2a → 3 → 4
    }

    @Test
    void findLongestConsecutive_SequenceAfterBreak_Longest3() {
        // Given
        List<Node> graph = List.of(GraphHelper.build("5->9->10->11").getFirst());

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(3); // 9 → 10 → 11
    }

    @Test
    void findLongestConsecutive_NegativeValuesAndIsolatedNode_Longest3() {
        // Given
        List<Node> graph = GraphHelper.build("-1->0->1 7");

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(3); // -1 → 0 → 1
    }

    @Test
    void findLongestConsecutive_EmptyGraph_Longest0() {
        // Given
        List<Node> graph = Collections.emptyList();

        // When
        int actualLongest = new DAGConsecutiveSequence().findLongestConsecutive(graph);

        // Then
        assertThat(actualLongest).isEqualTo(0);
    }

    private static class GraphHelper {

        private static final Pattern NODE_LABEL = Pattern.compile("(-?\\d+)(\\w*)");

        /**
         * Builds a DAG from space-separated paths, e.g. "1->2a->7 1->2b->3".
         * A label is an int value plus an optional suffix to tell apart nodes that have the same value.
         * Returns all nodes in the order they first appear.
         */
        private static List<Node> build(String spec) {
            Map<String, Node> mapNodes = new LinkedHashMap<>();
            for (String path : spec.trim().split("\\s+")) {
                Node parent = null;
                for (String label : path.split("->")) {
                    Node node = mapNodes.computeIfAbsent(label, GraphHelper::createNode);
                    if (parent != null && parent.children().stream().noneMatch(child -> child == node)) {
                        parent.children().add(node);
                    }
                    parent = node;
                }
            }
            return new ArrayList<>(mapNodes.values());
        }

        private static Node createNode(String label) {
            Matcher matcher = NODE_LABEL.matcher(label);
            if (matcher.matches()) {
                int nodeValue = Integer.parseInt(matcher.group(1));
                return new Node(nodeValue, new ArrayList<>());
            } else {
                throw new IllegalArgumentException("Invalid node label: " + label);
            }
        }
    }
}
