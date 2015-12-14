package string.sumbin;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumBinStrTest {

	@Test
	public void testSum() {
		
		assertEquals( "1011", SumBinStrSolution.sum( "110", "101" ) );
		
		assertEquals( "0", SumBinStrSolution.sum( "0", "0" ) );
		
		assertEquals( "111", SumBinStrSolution.sum( "111", "0" ) ); 
		
	}
	
	@Test 
	public void testSumCarry() {
		
		assertEquals( "10000", SumBinStrSolution.sum( "1111", "1" ) );
		
		assertEquals( "110", SumBinStrSolution.sum( "11", "11" ) );
		
	}

}
