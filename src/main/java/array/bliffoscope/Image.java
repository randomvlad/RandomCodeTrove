package array.bliffoscope;

/**
 * Represents a flat two dimensional "text" image. Each pixel of the image
 * is represented as a character. A pixel is located by specifying its
 * x-coordinate and y-coordinate. 
 * <p>
 * Example 3 x 3 Image:<br />
 * abc
 * def
 * ghi
 * <p>
 * Coordinate (0,0) points to 'a', while coordinate (2,2) to 'i'.
 * 
 * @author Vlad Poskatcheev
 */
public class Image {
	
	private String name;
	private char[][] pixelGrid;
	
	public Image() {
		this( "", null );
	}
	
	public Image( char[][] pixelGrid ) {
		this( "", pixelGrid );
	}
	
	public Image( String name, char[][] pixelGrid ) {
		this.name = name;
		this.pixelGrid = pixelGrid != null ? pixelGrid : new char[][] {};
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	/**
	 * @return A non-negative integer that represents the height of the image in pixels.
	 */
	public int getHeight() {
		return pixelGrid.length; 
	}

	/**
	 * @return A non-negative integer that represents the length of the image in pixels.
	 */
	public int getLength() {
		if( pixelGrid.length > 0 && pixelGrid[ 0 ] != null ) {
			return pixelGrid[ 0 ].length;
		} else {
			return 0;
		}
	}
	
	/**
	 * @return A non-negative integer that represents the resolution of the image. 
	 *         Resolution is calculated by multiplying height (in pixels) times 
	 *         length (in pixels)
	 */
	public int getResolution() {
		return getLength() * getHeight();
	}
	
	/**
	 * @return True if coordinate (x,y) is a valid pixel position within the image boundaries
	 * 
	 * @see #getPixelAt(int, int)
	 */
	public boolean hasPixelAt( int x, int y ) {
		return pixelGrid.length > 0 && y < pixelGrid.length 
				&& pixelGrid[ 0 ].length > 0 && x < pixelGrid[ 0 ].length;
	}
	
	/**
	 * @throws ArrayIndexOutOfBoundsException if x or y are out of bounds
	 * @see #hasPixelAt(int, int)
	 */
	public char getPixelAt( int x, int y ) {
		return pixelGrid[ y ][ x ];
	}
	
	/** 
	 * Compares this image to the provided image. Similarity between images
	 * is scored on a percentage scale from 0 to 1. 0 meaning not a single
     * pixel matched up, while 1 implying the images are equal. 
	 * <p>
	 * <b>Important Assumption</b>: similarity of images can ONLY be computed
	 * if both images are of the same dimensions and resolutions. Images
	 * of different dimensions, will result in a similarity score of -1.
	 *
	 * @return -1 if images do not have the same dimensions.
	 *         0 if the images are completely different (not a single pixel matches).
	 *         0 < x < 1 percentage score of how similar the images are.
	 *         1 is a perfect match, images are the same.
	 *
	 * @throws NullPointerException if image is null
	 */
	public double calculateSimilarity( Image image ) {
		boolean validImage = this.getLength() == image.getLength() 
				&& this.getHeight() == image.getHeight() && image.getResolution() > 0;
		if( ! validImage ) {
			return -1;
		}
		
		double matchedPixels = 0;
		for( int x = 0; x < image.getLength(); x++ ) {
			for( int y = 0; y < image.getHeight(); y++ ) {
				if( this.getPixelAt(x, y) == image.getPixelAt(x, y) ) {
					matchedPixels++;
				}
			}
		}
		
		return matchedPixels / (double)image.getResolution();
	}
	
	/**
	 * @return 	A subset image which was created at point (startX, startY) with 
	 * 			specified length and height. If the coordinates are invalid or 
	 * 			the length/height too long then an empty non-null image is returned.
	 * 
	 * @throws java.lang.NegativeArraySizeException if length or height are negative
	 */
	public Image createSubset( int startX, int startY, int length, int height ) {
		int endX = startX + length - 1;
		int endY = startY + height - 1; 
		if( ! hasPixelAt(startX, startY) || ! hasPixelAt(endX, endY) ) {
			return new Image();
		}
		
		char[][] subset = new char[ height ][ length ];
	
		for( int y = 0; y < height; y++ ) {
			for( int x = 0; x < length; x++ ) {
				subset[ y ][ x ] = getPixelAt( startX + x, startY + y );
			}
		}
		
		return new Image( subset );
	}
	
	@Override
	public String toString() {
		if( getResolution() == 0 ) {
			return "";
		}
		
		final String NEWLINE = System.getProperty( "line.separator" );
		StringBuilder sb = new StringBuilder();
		
		sb.append( " " );
		for( int x = 0; x < getLength(); x++ ) {
			sb.append( x );
		}
		sb.append( NEWLINE );
		
		for( int y = 0; y < getHeight(); y++ ) {
			sb.append( y );
			for( int x = 0; x < getLength(); x++ ) {
			  sb.append( getPixelAt( x, y ) );			
			}
			sb.append( NEWLINE );
		}
		
		return sb.toString();
	}
}