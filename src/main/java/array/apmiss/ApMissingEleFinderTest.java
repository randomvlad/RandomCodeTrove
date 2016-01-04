package array.apmiss;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ApMissingEleFinderTest {

	@Test
	public void testFindMissingIncreasing() {
		
		assertEquals( 0, ApMissingEleFinder.findMissing( Arrays.asList( -5, 5, 10, 15 ) ) );
		
		assertEquals( 4, ApMissingEleFinder.findMissing( Arrays.asList( 2, 6, 8, 10, 12, 14, 16 ) ) );
		
		assertEquals( 8, ApMissingEleFinder.findMissing( Arrays.asList( 2, 4, 6, 10, 12, 14, 16 ) ) );
		
		assertEquals( 10, ApMissingEleFinder.findMissing( Arrays.asList( 2, 4, 6, 8, 12, 14, 16 ) ) );
		
		assertEquals( 12, ApMissingEleFinder.findMissing( Arrays.asList( 2, 4, 6, 8, 10, 14, 16 ) ) );
	}
	
	@Test
	public void testFindMissingDecreasing() {
		
		assertEquals( 0, ApMissingEleFinder.findMissing( Arrays.asList( 18, -18, -36 ) ) );
		
		assertEquals( -14, ApMissingEleFinder.findMissing( Arrays.asList( -10, -12, -16, -18, -20, -22 ) ) );
	}
	
	@Test
	public void testFindMissingTail() {
		
		assertEquals( 7, ApMissingEleFinder.findMissing( Arrays.asList( 1, 2, 3, 4, 5, 6 ) ) );
		
		assertEquals( 4, ApMissingEleFinder.findMissing( Arrays.asList( -16, -12, -8, -4, 0 ) ) );	
	}

}
