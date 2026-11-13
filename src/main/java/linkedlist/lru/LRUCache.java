package linkedlist.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>
 */
public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // head.next = most recently used
    private final Node tail; // tail.prev = least recently used (up for eviction if criteria is met)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(); // Note: using linked hash map to preserve order for String() implementation and unit test comparisons

        // use of dummy/sentinel nodes to avoid handling nulls for adding new nodes at the front and
        // evicting nodes from the back. Results in more compact (and possibly "easier") code flow
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insertAtFront(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            // add new node; if cache at full capacity, evict the least recently node
            if (cache.size() == this.capacity) {
                Node lru = tail.prev;
                cache.remove(lru.key);
                remove(lru);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insertAtFront(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    @Override
    public String toString() {
        return String.format(
                "cache=%s, head=%s, tail=%s",
                cache,
                head.next != tail ? head.next.key : "null",
                tail.prev != null ? tail.prev.key : "null"
        );
    }

    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
