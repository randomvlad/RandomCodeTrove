package string.sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Permutator {

	private List<List<String>> permutations;

	public Permutator() {
		this.permutations = new ArrayList<>();
	}
	
	public List<String> permute( String value ) {
		List<List<String>> groups = extractGroups( value );
		String template = generateTemplate( value );
		
		List<String> sentences = new ArrayList<>();
		for ( List<String> permutations : permute( groups ) ) {
			sentences.add( String.format( template, permutations.toArray() ) );
		}
		
		return sentences;
	}

	private List<List<String>> permute( List<List<String>> groups ) {
		permutations.clear();
		permute( new ArrayList<>(), 0, groups );
		return permutations;
	}

	private void permute( List<String> permutation, int groupIndex, List<List<String>> groups ) {
		if ( groupIndex == groups.size() ) {
			permutations.add( permutation );
			return;
		}

		for ( String element : groups.get( groupIndex ) ) {
			List<String> newPermute = new ArrayList<>( permutation );
			newPermute.add( element );

			permute( newPermute, groupIndex + 1, groups );
		}
	}

	List<List<String>> extractGroups( String value ) {

		List<List<String>> groups = new ArrayList<>();

		Matcher matcher = Pattern.compile( "\\{([^\\}]+)" ).matcher( value );

		while ( matcher.find() ) {
			groups.add( Arrays.stream( matcher.group( 1 ).split( "," ) ).map( s -> s.trim() )
					.collect( Collectors.toList() ) );
		}

		return groups;
	}
	
	String generateTemplate( String value ) {
		return value.replaceAll( "\\{[^\\}]+\\}", "%s" );
	}

}
