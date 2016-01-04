package array.apmiss;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Arithmetic Progression Missing Element Finder
 * 
 * @see ApMissingEleFinderTest
 */
public class ApMissingEleFinder {

	public static void main( String[] args ) {
		List<Integer> sequence = readInput( System.in );
		System.out.println( findMissing( sequence ) );
	}
	
	public static int findMissing( List<Integer> sequence ) {
		
		int step = findStep( sequence );
		
		// perform a binary search for missing element in O(log(n))
		int start = 0;
		int end = sequence.size() - 1;
		while ( start <= end ) {
			
			int middle = start + ( end - start ) / 2;
			
			int expected = sequence.get( 0 ) + step * middle;
			
			if ( expected == sequence.get( middle ) ) {
				start = middle + 1;
			} else {
				return expected;
			}
		}
		
		// all elements in sequence were valid, assume missing must be at end of sequence
		return sequence.get( 0 ) + step * sequence.size(); 
	}
	
	public static int findStep( List<Integer> sequence ) {
		int first = sequence.get( 0 );
		int second = sequence.get( 1 );
		int third = sequence.get( 2 );
		
		int step = Math.min( Math.abs( second - first ), Math.abs( third - second ) );
		
		if ( second - first < 0 ) {
			step *= -1;
		}
		
		return step;
	}
	
	public static List<Integer> readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
		
		int length = scanner.nextInt();
		List<Integer> sequence = new ArrayList<>( length );
		
		for ( int i = 0; i < length; i++ ) {
			sequence.add( scanner.nextInt() );
		}
		
		scanner.close();
		
		return sequence;
	}

}
