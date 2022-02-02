package linkedlist.copyrand;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer">Copy List with Random Pointer</a>
 */
public class Solution {

    /**
     * Solution with a HashMap.
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalToCopy = new HashMap<>();

        Node current = head;
        while (current != null) {
            originalToCopy.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copy = originalToCopy.get(current);

            copy.next = originalToCopy.get(current.next);
            copy.random = originalToCopy.get(current.random);

            current = current.next;
        }

        return originalToCopy.get(head);
    }

    // TODO: a more clever implementation exits without using a HashMap
    // See: https://leetcode.com/problems/copy-list-with-random-pointer/discuss
    public Node copyRandomListNoMap(Node head) {
        return null;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
