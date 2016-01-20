package list.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseListTest {

	@Test	
	public void testReverse() {
		
		LinkedList list = ReverseListMain.create( "abcdef" );
		assertEquals( "f -> e -> d -> c -> b -> a", list.reverse().toString() );
		assertEquals( "a -> b -> c -> d -> e -> f", list.reverse().toString() );
		
	}
	
	@Test
	public void testReverseRecursive() {
	
		LinkedList list = ReverseListMain.create( "abcdef" );
		assertEquals( "f -> e -> d -> c -> b -> a", list.reverseRecursive().toString() );
		assertEquals( "a -> b -> c -> d -> e -> f", list.reverseRecursive().toString() );
	}
	
	@Test
	public void testReversePairs() {
		
		LinkedList listOdd = ReverseListMain.create( "abcde" );
		assertEquals( "d -> e -> b -> c -> a", listOdd.reversePairs().toString() );
		assertEquals( "c -> a -> e -> b -> d", listOdd.reversePairs().toString() );
		
		LinkedList listEven = ReverseListMain.create( "abcdef" );
		assertEquals( "e -> f -> c -> d -> a -> b", listEven.reversePairs().toString() );
		assertEquals( "a -> b -> c -> d -> e -> f", listEven.reversePairs().toString() );
		
	}
	
	@Test
	public void testReverseAlternateK() {
		
		LinkedList list = ReverseListMain.create( "abc" );
		assertEquals( "c -> b -> a", list.reverseAlternateK( 3 ).toString() );
		
		list = ReverseListMain.create( "abc" );
		assertEquals( "c -> b -> a", list.reverseAlternateK( 5 ).toString() );
		
		list = ReverseListMain.create( "abcde" );
		assertEquals( "b -> a -> c -> d -> e", list.reverseAlternateK( 2 ).toString() );
		
		list = ReverseListMain.create( "abcdefghi" );
		assertEquals( "c -> b -> a -> d -> e -> f -> i -> h -> g", list.reverseAlternateK( 3 ).toString() );
		assertEquals( "a -> b -> c -> d -> e -> f -> g -> h -> i", list.reverseAlternateK( 3 ).toString() );
		
		list = ReverseListMain.create( "abcdef" );
		assertEquals( "e -> d -> c -> b -> a -> f", list.reverseAlternateK( 5 ).toString() );
		
	}

}
