package string.sentence;

import java.util.Scanner;

/**
 * @see SentencePermuteTest
 */
public class SentencePermuteMain {
	
	public static void main( String[] args ) {
		
		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		scanner.close();
		
		Permutator permutator = new Permutator();
		for ( String sentence : permutator.permute( input ) ) {
			System.out.println( sentence );
		}
	}
}
