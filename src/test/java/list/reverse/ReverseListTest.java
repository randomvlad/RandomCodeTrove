package list.reverse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ReverseListTest {

    @Test
    public void reverse_ReverseTwice_Identity() {
        LinkedList list = ReverseListMain.create("abcdef");

        list.reverse();
        assertThat(list.toString()).isEqualTo("f -> e -> d -> c -> b -> a");

        list.reverse();
        assertThat(list.toString()).isEqualTo("a -> b -> c -> d -> e -> f");
    }

    @Test
    public void reverseRecursive_List_Reversed() {
        LinkedList list = ReverseListMain.create("abcdef");

        list.reverseRecursive();
        assertThat(list.toString()).isEqualTo("f -> e -> d -> c -> b -> a");

        list.reverseRecursive();
        assertThat(list.toString()).isEqualTo("a -> b -> c -> d -> e -> f");
    }

    @Test
    public void reversePairs_OddList_PairsReversed() {
        LinkedList listOdd = ReverseListMain.create("abcde");

        listOdd.reversePairs();
        assertThat(listOdd.toString()).isEqualTo("d -> e -> b -> c -> a");

        listOdd.reversePairs();
        assertThat(listOdd.toString()).isEqualTo("c -> a -> e -> b -> d");
    }

    @Test
    public void reversePairs_EvenList_PairsReversed() {
        LinkedList listEven = ReverseListMain.create("abcdef");

        listEven.reversePairs();
        assertThat(listEven.toString()).isEqualTo("e -> f -> c -> d -> a -> b");

        listEven.reversePairs();
        assertThat(listEven.toString()).isEqualTo("a -> b -> c -> d -> e -> f");
    }

    @Test
    public void reverseAlternateK_Lists_ReversedAlternateK() {
        LinkedList list = ReverseListMain.create("abc");
        list.reverseAlternateK(3);
        assertThat(list.toString()).isEqualTo("c -> b -> a");

        list = ReverseListMain.create("abcde");
        list.reverseAlternateK(2);
        assertThat(list.toString()).isEqualTo("b -> a -> c -> d -> e");

        list = ReverseListMain.create("abcdefghi");
        list.reverseAlternateK(3);
        assertThat(list.toString()).isEqualTo("c -> b -> a -> d -> e -> f -> i -> h -> g");

        list.reverseAlternateK(3);
        assertThat(list.toString()).isEqualTo("a -> b -> c -> d -> e -> f -> g -> h -> i");

        list = ReverseListMain.create("abcdef");
        list.reverseAlternateK(5);
        assertThat(list.toString()).isEqualTo("e -> d -> c -> b -> a -> f");
    }
}
