package list.reverse;

import java.util.Scanner;

/**
 * Reverse Linked List Main
 * 
 * @see ReverseListTest
 */
public class ReverseListMain {

	public static void main( String[] args ) {
		
		Scanner scanner = new Scanner( System.in );
		String elements = scanner.next();
		int reverseAltK = scanner.nextInt();
		scanner.close();
		
		LinkedList list = create( elements );
		System.out.println( list.reverse().toString() );

		list = create( elements );
		System.out.println( list.reversePairs().toString() );
		
		list = create( elements );
		System.out.println( list.reverseAlternateK( reverseAltK ).toString() );
	}
	
	public static LinkedList create( String elements ) {
	
		LinkedList list = new LinkedList();
		for ( int i = 0; i < elements.length(); i++ ) {
			list.add( elements.charAt( i ) + "" );
		}
		
		return list;
	}

}
