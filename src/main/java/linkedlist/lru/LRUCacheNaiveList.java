package linkedlist.lru;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @see linkedlist.lru.LRUCacheNaiveListTest
 */
public class LRUCacheNaiveList {

    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final List<Integer> orderedKeyUsage;

    public LRUCacheNaiveList(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
        this.orderedKeyUsage = new ArrayList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(key);
            insert(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(key);
            insert(key);
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                Integer lruKey = orderedKeyUsage.getFirst();
                remove(lruKey);
                cache.remove(lruKey);
            }
            cache.put(key, value);
            insert(key);
        }
    }

    /**
     * Time Complexity Note: searching for an element in a list is O(n). Removing an element from a list
     * requires shifting/copying the underlying array accordingly which is also O(n)
     */
    private void remove(Integer key) {
        orderedKeyUsage.remove(key);
    }

    /**
     * Time Complexity Note: adding an element at end of an ArrayList is O(1) assuming no resizing is needed.
     * <p>Resizing a Java ArrayList is O(n) for the single resize operation. It leads to an amortized O(1) time
     * complexity for appending elements.
     */
    private void insert(Integer key) {
        orderedKeyUsage.add(key);
    }

    public String toString() {
        return String.format(
                "cache=%s, lru=%s",
                cache,
                orderedKeyUsage.isEmpty() ? "empty" : orderedKeyUsage.getFirst()
        );
    }
}
