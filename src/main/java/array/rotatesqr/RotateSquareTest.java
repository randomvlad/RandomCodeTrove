package array.rotatesqr;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateSquareTest {
	
	public final static String NL = System.lineSeparator();
	
	@Test
	public void testRotateThreeByTree() {
		int[][] square = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		
		assertEquals( 
				"4 1 2" + NL + 
				"7 5 3" + NL + 
				"8 9 6",
				new SquareRotater( square ).rotate().toString()
		);
	}
	
	@Test
	public void testRotateFiveByFive() {
		
		int[][] square = {
				{ 110, 111, 112, 113, 114 },
				{ 125, 220, 221, 222, 115 },
				{ 124, 227, 999, 223, 116 },
				{ 123, 226, 225, 224, 117 },
				{ 122, 121, 120, 119, 118 }
		};
		
		assertEquals( 
				"125 110 111 112 113" + NL + 
				"124 227 220 221 114" + NL + 
				"123 226 999 222 115" + NL +
				"122 225 224 223 116" + NL + 
				"121 120 119 118 117",
				new SquareRotater( square ).rotate().toString()
		);
		
	}

}
