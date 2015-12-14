package array.rotatesqr;

import java.util.Scanner;

/**
 * Rotate Square Array Clockwise
 * 
 * @see RotateSquareTest
 */
public class RotateSquareSolution {

	public static void main( String[] args ) {
		
		System.out.println( new SquareRotater( readInput() ).rotate().toString() );
		
	}

	public static int[][] readInput() {

		// TODO: print ERROR if matrix is not a square

		Scanner scanner = new Scanner( System.in );

		int dimension = scanner.nextInt();

		int[][] matrix = new int[ dimension ][ dimension ];

		for ( int i = 0; i < dimension; i++ ) {
			for ( int j = 0; j < dimension; j++ ) {
				matrix[ i ][ j ] = scanner.nextInt();
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
		int length = matrix.length;
		for ( int i = 0; i < matrix.length / 2; i++ ) {
			rotateLayer( matrix, i, i, length );
			length -= 2;
		}
		
		return this;
	}

	public void rotateLayer( int[][] matrix, int x, int y, int layerWidth ) {
		if ( layerWidth <= 1 ) {
			return;
		}

		int xMin = x;
		int yMin = y;
		int replaced = matrix[ y ][ x ];

		for ( int i = 0; i < layerWidth * layerWidth; i++ ) {

			int[] steps = calcStepIncrement( x, y, xMin, yMin, layerWidth );
			int xStep = steps[ 0 ];
			int yStep = steps[ 1 ];

			int xNext = x + xStep;
			int yNext = y + yStep;

			int temp = matrix[ yNext ][ xNext ];
			matrix[ yNext ][ xNext ] = replaced;
			replaced = temp;

			x = xNext;
			y = yNext;
		}
	}

	private int[] calcStepIncrement( int x, int y, int xMin, int yMin, int layerWidth ) {

		int xMax = xMin + layerWidth - 1;
		int yMax = yMin + layerWidth - 1;

		int xStep = -1;
		int yStep = -1;

		if ( y == yMin && x <= xMax - 1 ) {
			// move: left to right along y-axis
			xStep = 1;
			yStep = 0;
		} else if ( x == xMax && y <= yMax - 1 ) {
			// move: top to bottom along x-axis
			xStep = 0;
			yStep = 1;
		} else if ( y == yMax && xMin + 1 <= x ) {
			// move: right to left along y-axis
			xStep = -1;
			yStep = 0;
		} else if ( x == xMin && yMin + 1 <= y ) {
			// move bottom to top along x-axis
			xStep = 0;
			yStep = -1;
		} else {
			throw new IllegalStateException( "Unknown steps for (x,y) = (" + x + "," + y + ")" );
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
