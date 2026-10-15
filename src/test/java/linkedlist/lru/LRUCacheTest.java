package linkedlist.lru;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LRUCacheTest {

    @Test
    public void testCache_LeetCodeSampleInput_ExpectedResults() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        assertThat(cache.toString()).isEqualTo("cache={1=1}, head=1, tail=1");

        cache.put(2, 2);
        assertThat(cache.toString()).isEqualTo("cache={1=1, 2=2}, head=2, tail=1");

        assertThat(cache.get(1)).isEqualTo(1);
        assertThat(cache.toString()).isEqualTo("cache={1=1, 2=2}, head=1, tail=2");

        cache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertThat(cache.toString()).isEqualTo("cache={1=1, 3=3}, head=3, tail=1");

        assertThat(cache.get(2)).isEqualTo(-1); // not found

        cache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertThat(cache.toString()).isEqualTo("cache={4=4, 3=3}, head=4, tail=3");

        assertThat(cache.get(1)).isEqualTo(-1); // not found
        assertThat(cache.toString()).isEqualTo("cache={4=4, 3=3}, head=4, tail=3");

        assertThat(cache.get(3)).isEqualTo(3);
        assertThat(cache.toString()).isEqualTo("cache={4=4, 3=3}, head=3, tail=4");

        assertThat(cache.get(4)).isEqualTo(4);
        assertThat(cache.toString()).isEqualTo("cache={4=4, 3=3}, head=4, tail=3");
    }

    @Test
    public void testCache_CapacityOne_HeadTailAlwaysSame() {
        LRUCache cache = new LRUCache(1);

        cache.put(2, 1);
        assertThat(cache.get(2)).isEqualTo(1);

        cache.put(3, 2);
        assertThat(cache.toString()).isEqualTo("cache={3=2}, head=3, tail=3");

        assertThat(cache.get(2)).isEqualTo(-1);

        assertThat(cache.get(3)).isEqualTo(2);
        assertThat(cache.toString()).isEqualTo("cache={3=2}, head=3, tail=3");
    }
}
