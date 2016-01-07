package list.reverse;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Reverse Linked List Main
 * 
 * @see ReverseListTest
 */
public class ReverseListMain {

	public static void main( String[] args ) {
		
		LinkedList list = readInput( System.in );
				
		list.reverse();
		System.out.println( list );
		
		list.reverse();
		list.reversePairs();
		
		System.out.println( list );
	}
	
	public static LinkedList readInput( InputStream stream ) {
		Scanner scanner = new Scanner( stream );
		LinkedList list = create( scanner.next() );
		scanner.close();
		return list;
	}
	
	public static LinkedList create( String elements ) {
	
		LinkedList list = new LinkedList();
		for ( int i = 0; i < elements.length(); i++ ) {
			list.add( elements.charAt( i ) + "" );
		}
		
		return list;
	}

}
