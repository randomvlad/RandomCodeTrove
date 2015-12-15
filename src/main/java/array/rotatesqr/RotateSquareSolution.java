package array.rotatesqr;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Rotate Square Array Clockwise
 * 
 * @see RotateSquareTest
 */
public class RotateSquareSolution {

	public static void main( String[] args ) {
		
		int[][] matrix = readInput( System.in );
		if ( matrix == null ) {
			System.out.println( "ERROR" );
			return;
		}
		
		System.out.println( new SquareRotater( matrix ).rotate().toString() );
	}

	public static int[][] readInput( InputStream stream ) {
		
		Scanner scanner = new Scanner( stream );
	
		int dimension = Integer.valueOf( scanner.nextLine() );

		int[][] matrix = new int[ dimension ][ dimension ];

		for ( int i = 0; i < dimension; i++ ) {
			
			String[] numbers = scanner.nextLine().split( "\\s+" );
			
			if ( numbers.length != dimension ) {
				scanner.close();
				return null;
			}
			
			for ( int j = 0; j < dimension; j++ ) {
				matrix[ i ][ j ] = Integer.valueOf( numbers[ j ] );
			}
		}
		
		scanner.close();

		return matrix;
	}
}

class SquareRotater {

	private int[][] matrix;

	public SquareRotater( int[][] matrix ) {
		this.matrix = matrix;
	}

	public SquareRotater rotate() {
		
		for ( int layerIndex = 0; layerIndex < matrix.length / 2; layerIndex++ ) {
			rotateLayer( matrix, layerIndex );
		}
		
		return this;
	}

	public void rotateLayer( int[][] matrix, int layerIndex ) {
		int length = getLayerLength( layerIndex );
		if ( length <= 1 ) {
			return;
		}
		
		int x = layerIndex;
		int y = layerIndex;
		
		int replaced = matrix[ y ][ x ];
		
		int numberSwaps = 4 * (length - 1);
		for ( int i = 0; i < numberSwaps; i++ ) {

			int[] steps = calcStepIncrement( x, y, layerIndex, length );
			
			int xNext = x + steps[ 0 ];
			int yNext = y + steps[ 1 ];

			int temp = matrix[ yNext ][ xNext ];
			matrix[ yNext ][ xNext ] = replaced;
			replaced = temp;

			x = xNext;
			y = yNext;
		}
	}
	
	private int getLayerLength( int layerIndex ) {
		int length = matrix.length - 2 * layerIndex;
		return length >= 1 ? length : 0;
	}

	private int[] calcStepIncrement( int x, int y, int layerIndex, int layerWidth ) {

		int xMin = layerIndex;
		int yMin = layerIndex;				
		int xMax = xMin + layerWidth - 1;
		int yMax = yMin + layerWidth - 1;

		int xStep = 0;
		int yStep = 0;

		if ( y == yMin && x < xMax ) {
			// x moves left to right along y-axis
			xStep = 1;
		} else if ( x == xMax && y < yMax ) {
			// y moves top to bottom along x-axis
			yStep = 1; 
		} else if ( y == yMax && xMin < x ) {
			// x moves right to left along y-axis
			xStep = -1; 
		} else if ( x == xMin && yMin < y ) {
			// y moves bottom to top along x-axis
			yStep = -1; 
		}
		
		return new int[] { xStep, yStep };
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0; i < matrix.length; i++ ) {
			if ( i > 0 ) {
				sb.append( System.lineSeparator() );
			}
			
			for ( int j = 0; j < matrix.length; j++ ) {
				if ( j > 0 ) {
					sb.append( " " );
				}

				sb.append( matrix[ i ][ j ] );
			}
		}

		return sb.toString();
	}
	
}
