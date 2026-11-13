package linkedlist.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>
 *
 * Vlad's personal implementation (derived without looking at the popular LeetCode solution of ({@link LRUCache}).
 * Solution does not use sentinel nodes for head & tail, and hence is a little more verbose.
 * <p>
 * Utilizes three private helper methods: addNewNodeAsHead(), moveExistingToHead() and evictLeastRecentlyUsed().
 */
public class LRUCacheVladVersion {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCacheVladVersion(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        moveExistingToHead(node);
        return node.value;
    }

    /**
     * Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the
     * number of keys exceeds the capacity from this operation, evict the least recently used key.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveExistingToHead(node);
            node.value = value;
        } else {
            if (cache.size() == this.capacity) {
                evictLeastRecentlyUsed();
            }

            Node newNode = new Node(key, value);
            addNewNodeAsHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void addNewNodeAsHead(Node newHead) {
        if (cache.isEmpty()) { // empty cache, point head and tail to new node
            head = newHead;
            tail = newHead;
            return;
        }

        newHead.next = head;
        head.prev = newHead;
        head = newHead;
    }

    private void moveExistingToHead(Node newHead) {
        if (newHead.prev == null) {
            return;  // node is already the head and most recently used
        }

        Node prevNode = newHead.prev;
        Node nextNode = newHead.next;
        if (nextNode == null) {
            prevNode.next = null;
            tail = prevNode; // tail is being moved to head, set a new tail to previous node
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // make this node the new head (aka most recently used)
        newHead.next = head;
        newHead.next.prev = newHead;
        newHead.prev = null;
        head = newHead;
    }

    private void evictLeastRecentlyUsed() {
        int leastRecentlyUsed = tail.key;
        cache.remove(leastRecentlyUsed);

        Node newTail = tail.prev;
        if (newTail != null) {
            newTail.next = null;
            tail.prev = null;
        }
        tail = newTail;
    }

    @Override
    public String toString() {
        return String.format(
                "cache=%s, head=%s, tail=%s",
                cache,
                head != null ? head.key : "null",
                tail != null ? tail.key : "null"
        );
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;

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
