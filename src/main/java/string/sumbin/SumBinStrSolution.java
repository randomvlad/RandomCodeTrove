package string.sumbin;

/**
 * @see SumBinStr.md
 */
public class SumBinStrSolution {

	// TODO: add Scanner & JUnit Test
	
	public static void main( String[] args ) {
		// '110' = 6
		// '101' = 5
		// '1011' = 11
		// sum = addStrings('110', '101'); // sum is '1011'

		System.out.println( addStrings( "111", "111" ) );
	}
	
	// Runtime: O(n), where n = characters in max( number1.length, number.length );
	// Space complexity: O(1)
	public static String addStrings( String number1, String number2 ) {

		String sum = "";
		int carry = 0;
		int length = Math.max( number1.length(), number2.length() );
		
		for ( int i = length - 1; i >= 0; i-- ) {
			int num1 = isValidIndex( number1, i ) ? Integer.valueOf( number1.charAt( i ) ) : 0;
			int num2 = isValidIndex( number2, i ) ? Integer.valueOf( number2.charAt( i ) ) : 0;

			int intermediateSum = num1 + num2 + carry;

			sum = String.valueOf( intermediateSum % 2 ) + sum;

			if ( intermediateSum > 1 ) {
				carry = intermediateSum / 2;
			} else {
				carry = 0;
			}
		}

		if ( carry > 0 ) {
			sum = "1" + sum;
		}

		return sum;
	}

	public static boolean isValidIndex( String str, int index ) {
		return index >= 0 && index < str.length();
	}

}
