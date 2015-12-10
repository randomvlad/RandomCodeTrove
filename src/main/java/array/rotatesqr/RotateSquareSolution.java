package array.rotatesqr;

import java.util.Scanner;

/**
 * Rotate Square Array Clockwise
 */
public class RotateSquareSolution {

	// TODO: JUnit Test
	
// todo: BUG
	
//5
//110 111 112 113 114
//125 220 221 222 115
//124 227 999 223 116
//123 226 225 224 117
//122 121 120 119 118
	
//125 110 110 111 112 
//124 227 220 221 113 
//123 226 999 222 114 
//122 225 224 223 115 
//121 120 119 117 116 	
	
	
	public static void main( String[] args ) {

		int[][] matrix = readInput();
		
		int length = matrix.length;
		for ( int i = 0; i < matrix.length / 2; i++ ) {
			rotateLayer( matrix, i, i, length );
			length -= 2;
		}
		
		print( matrix );
	}
	
	public static void rotateLayer( int[][] matrix, int x, int y, int layerWidth ) {
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
	
	private static int[] calcStepIncrement( int x, int y, int xMin, int yMin, int layerWidth ) {
		
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
	
	public static void print( int[][] matrix ) {
		for ( int i = 0; i < matrix.length; i++ ) {
			for ( int j = 0; j < matrix.length; j++ ) {
				System.out.print( matrix[ i ][ j ] + " " );
			}
			
			System.out.println( "" );
		}
	}

}
