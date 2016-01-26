package string.sentence;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SentencePermuteTest {

	@Test
	public void testExtractGroups() {
		
		Permutator permutator = new Permutator();
		
		List<List<String>> groups = permutator.extractGroups( "{A, B} then {1, 2, 3} and finally {w, x, y, z}" );
		assertEquals( 3, groups.size() );
		
		List<String> first = groups.get( 0 );
		assertEquals( 2, first.size() );
		assertEquals( "A", first.get( 0 ) );
		assertEquals( "B", first.get( 1 ) );
		
		List<String> second = groups.get( 1 );
		assertEquals( 3, second.size() );
		assertEquals( "1", second.get( 0 ) );
		assertEquals( "2", second.get( 1 ) );
		assertEquals( "3", second.get( 2 ) );
		
		List<String> third = groups.get( 2 );
		assertEquals( 4, third.size() );
		assertEquals( "w", third.get( 0 ) );
		assertEquals( "x", third.get( 1 ) );
		assertEquals( "y", third.get( 2 ) );
		assertEquals( "z", third.get( 3 ) );
	}
	
	@Test
	public void testGenerateTemplate() {
		
		Permutator permutator = new Permutator();
		assertEquals( "%s with %s and %s", permutator.generateTemplate( "{A} with {B,C} and {D,E,F}" ) );
	}
	
	@Test
	public void testSentences() {
	
		Permutator permutator = new Permutator();
		List<String> sentences = permutator.permute( 
				"{Vlad} was in {fantastic, crabby} mood and went to the {beach, party, library}." );
		
		List<String> expected = Arrays.asList( 
				"Vlad was in fantastic mood and went to the beach.",
				"Vlad was in fantastic mood and went to the party.",
				"Vlad was in fantastic mood and went to the library.",
				"Vlad was in crabby mood and went to the beach.",
				"Vlad was in crabby mood and went to the party.",
				"Vlad was in crabby mood and went to the library."
		);
		
		assertEquals( expected.size(), sentences.size() );
		
		for ( int i = 0; i < sentences.size(); i++ ) {
			assertEquals( expected.get( i ), sentences.get( i ) );
		}
	}

}
