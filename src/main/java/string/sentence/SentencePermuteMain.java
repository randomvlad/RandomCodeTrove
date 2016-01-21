package string.sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @see SentencePermuteTest
 */
public class SentencePermuteMain {

	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in );
		String input = scanner.nextLine();
		scanner.close();

		List<List<String>> groups = extractGroups( input );
	
		permutations( new ArrayList<>(), 0, groups );
	}
	
	public static void permutations( List<String> permutation, int groupIndex, List<List<String>> groups ) {
		if ( groupIndex == groups.size() ) {
			System.out.println( permutation );
			return;
		}

		for ( String element : groups.get( groupIndex ) ) {

			// not a fan of constantly re-creating lists
			// could do a String[ group1.size() * group2.size() etc ... ][ number groups ]
			// Example: (A,B) + (1,2) + (x,y,z) => String[ 12 ][ 3 ]; Keep track of permutation ID somehow
			List<String> newPermute = new ArrayList<>( permutation );
			newPermute.add( element );

			permutations( newPermute, groupIndex + 1, groups );
		}
	}

	public static List<List<String>> extractGroups( String value ) {

		List<List<String>> groups = new ArrayList<>();

		Matcher matcher = Pattern.compile( "\\{([^\\}]+)" ).matcher( value );

		while ( matcher.find() ) {
			groups.add( 
					Arrays.stream( matcher.group( 1 ).split( "," ) )
					.map( s -> s.trim() )
					.collect( Collectors.toList() ) 
			);
		}

		return groups;
	}

}
