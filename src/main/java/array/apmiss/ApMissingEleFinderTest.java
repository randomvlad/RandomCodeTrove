package array.apmiss;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ApMissingEleFinderTest {

	@Test
	public void testFindMissingIncreasing() {
		
		assertEquals( 6, ApMissingEleFinder.findMissing( Arrays.asList( 2, 4, 8 ) ) );
		
		assertEquals( 0, ApMissingEleFinder.findMissing( Arrays.asList( -5, 5, 10, 15 ) ) );
	}
	
	@Test
	public void testFindMissingDecreasing() {
		
		assertEquals( 0, ApMissingEleFinder.findMissing( Arrays.asList( 18, -18, -36 ) ) );
		
		assertEquals( -14, ApMissingEleFinder.findMissing( Arrays.asList( -10, -12, -16 ) ) );
	}
	
	@Test
	public void testFindMissingTail() {
		
		assertEquals( 4, ApMissingEleFinder.findMissing( Arrays.asList( 1, 2, 3 ) ) );
		
		assertEquals( 4, ApMissingEleFinder.findMissing( Arrays.asList( -8, -4, 0 ) ) );	
	}

}
