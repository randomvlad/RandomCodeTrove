package string.braces;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Braces Validator 
 * 
 * @see BracesTest
 */
public class BracesSolution {
	
	public static void main( String[] args ) {
		
		BracesValidator validator = new BracesValidator();
		
		for ( String value : readInput( System.in ) ) {
			Result result = validator.validate( value );
			System.out.println( result.getValidMessage() );
		}
	}
	
	public static List<String> readInput( InputStream input ) {
		
		Scanner scanner = new Scanner( input );
		
		int number = Integer.valueOf( scanner.nextLine() );
		List<String> values = new ArrayList<>( number );
		for ( int i = 0; i < number; i++ ) {
			values.add( scanner.nextLine() );
		}
		
		scanner.close();
		
		return values;
	}
}