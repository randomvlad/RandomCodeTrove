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
		
		String[] data = readInput( System.in );
		
		LinkedList list = new LinkedList ( data );
		
		list.reverse();
		
		System.out.println( list );
		
		list.reverse();
		list.reversePairs();
		
		System.out.println( list );
	}
	
	public static String[] readInput( InputStream stream ) {
		Scanner scanner = new Scanner( stream );
		
		String data = scanner.next();
		
		scanner.close();
		
		String[] elements = new String[ data.length() ];
		for ( int i = 0; i < data.length(); i++ ) {
			elements[ i ] = data.charAt( i ) + "";
		}
		
		return elements;
	}

}
