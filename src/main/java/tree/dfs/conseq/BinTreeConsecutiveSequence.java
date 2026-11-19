package tree.dfs.conseq;

import annotation.DepthFirstSearch;

/**
 * Problem Description:
 * <p>
 * You are given the root of a binary tree. Your task is to find the length of the longest consecutive sequence path in the tree.
 * <p>
 * A consecutive sequence path is defined as a path where each node's value is exactly one more than its parent node's value in the path. For example, a path with values 1 → 2 → 3 is a consecutive sequence.
 *
 * @see <a href="https://neetcode.io/solutions/binary-tree-longest-consecutive-sequence">Binary Tree Longest Consecutive Sequence</a>
 * @see <a href="https://algo.monster/liteproblems/298">AlgoMonster: 298. Binary Tree Longest Consecutive Sequence</a>
 */
@DepthFirstSearch
public class BinTreeConsecutiveSequence {
    /*
       Notes:
           - depth-first search
           - longest consecutive sequence can be any part of the subtree
           - bottom up approach lends itself to post-order traversal (left/right/node)
           - in order to be consecutive need to satisfy: parent.value + 1 == child.value
           - choose max sequence from left and right children. keep track of a global and local max
   */

    static int globalMax;

    public int findLongestConsecutiveSequence(Node<Integer> root) {
        globalMax = 0;

        if (root != null) {
            depthFirstSearch(root);
        }

        return globalMax;
    }

    private int depthFirstSearch(Node<Integer> node) {
        int length = 1;

        boolean hasChild = node.left != null || node.right != null;
        if (hasChild) {
            if (node.left != null) {
                int leftSeq = depthFirstSearch(node.left);

                if ((node.value + 1) == node.left.value) {
                    length = Math.max(length, leftSeq + 1);
                }
            }

            if (node.right != null) {
                int rightSeq = depthFirstSearch(node.right);

                if ((node.value + 1) == node.right.value) {
                    length = Math.max(length, rightSeq + 1);
                }
            }
        }

        globalMax = Math.max(length, globalMax);

        return length;
    }

    public static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
