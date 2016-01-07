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

}
