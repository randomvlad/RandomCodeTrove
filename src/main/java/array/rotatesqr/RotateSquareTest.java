package array.rotatesqr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class RotateSquareTest {
	
	public final static String NL = System.lineSeparator();
	
	@Test
	public void testInvalidDimensionInput() {
		
		String input = "2" + NL +
				"1 2" + NL +
				"3 4 5 6 7";
		
		int[][] matrix = RotateSquareSolution.readInput( new ByteArrayInputStream( input.getBytes() ) );
		
		assertNull( matrix );
	}
	
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
	public void testRotateFourByFour() {
		int[][] square = {
				{ 100, 101, 102, 103 },
				{ 111, 200, 201, 104 },
				{ 110, 203, 202, 105 },
				{ 109, 108, 107, 106 }
		};
		
		assertEquals( 
				"111 100 101 102" + NL + 
				"110 203 200 103" + NL +
				"109 202 201 104" + NL +
				"108 107 106 105",
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
