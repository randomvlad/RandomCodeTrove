package list.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseListTest {

	@Test	
	public void testReverse() {

		LinkedList list = new LinkedList( "A", "B", "C", "D", "E" );
		
		list.reverse();

		assertEquals( "TODO", list.toString() );
	}
	
	// TODO: test even and odd
	@Test
	public void testReversePairs() {
		LinkedList list = new LinkedList( "A", "B", "C", "D", "E" );
		
		list.reversePairs();
		
		assertEquals( "TODO", list.toString() );
		
		list = new LinkedList( "A", "B", "C", "D", "E", "F" );		
	}

}
