package dfs.conseq;

import annotation.DepthFirstSearch;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: given a directed acyclic graph (DAG), find the longest consecutive sequence of integers.
 * Consecutive path is defined as "parent.value + 1 = child.value". Example: 1 → 2 → 3
 * <p>
 * Uses a recursive memoized DFS solution. Complexity: O(V + E) time and O(V) space
 */
@DepthFirstSearch
public class DAGConsecutiveSequence {

    private int globalMax = 0;
    private Map<Node, Integer> map;

    public int findLongestConsecutive(List<Node> graph) {
        globalMax = 0;
        map = new IdentityHashMap<>();
        if (graph == null) {
            return globalMax;
        }

        for (Node node : graph) {
            traverse(node);
        }

        return globalMax;
    }

    private int traverse(Node node) {
        if (map.containsKey(node)) {
            return map.get(node); // have already explored this subgraph and arrived at a local max
        }

        int max = 1;
        if (node.children != null) {
            for (Node child : node.children) {
                int subgraphMax = traverse(child);
                if (node.value + 1 == child.value) {
                    max = Math.max(max, subgraphMax + 1);
                }
            }
        }

        globalMax = Math.max(globalMax, max);
        map.put(node, max);

        return max;
    }

    public record Node(int value, List<Node> children) {
    }
}
