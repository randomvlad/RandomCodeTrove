package array.bliffoscope;

import java.util.*;
import java.awt.Point;

/**
 * @author Vlad Poskatcheev
 */
public class BliffoscopeDetector {
	
	public static BliffoscopeDetector getInstance() {
		final double DEFAULT_ACCURACY = 0.75;
		return new BliffoscopeDetector( DEFAULT_ACCURACY );
	}
	
	private double acceptableAccuracy; 
	
	private BliffoscopeDetector( double defaultAccuracy ) {
		acceptableAccuracy = defaultAccuracy;
	}
	
	/**
	 * @param accuracy percentage must be within 0 to 1 range
	 * @see #detect(Image, Image)
	 */
	public void setAcceptableAccuracy( double accuracy ) {
		if( accuracy >= 0 && accuracy <= 1 ) {
			acceptableAccuracy = accuracy; 
		}
	}
	
	/**
	 * @return Detection accuracy percentage within 0 to 1 range
	 */
	public double getAcceptableAccuracy() {
		return acceptableAccuracy;
	}
	
	/**
	 * Detects all potential instances of a target image in source image. 
	 * Detection allows for approximation of target image. An accuracy percentage 
	 * controls how exact a match has to be.
	 * 
	 * @return A non-null list of detection results
	 * @see #setAcceptableAccuracy(double)
	 * @throws NullPointerException if either source or target are null
	 */
	public List<DetectionResult> detect( Image source, Image target ) {
		List<DetectionResult> results = new ArrayList<DetectionResult>();
		
		int xEnd = source.getLength() - target.getLength();
		int yEnd = source.getHeight() - target.getHeight();
		
		for( int x = 0; x <= xEnd; x++ ) {
			for( int y = 0; y <= yEnd; y++ ) {
				Image subsetImage = source.createSubset( x, y, 
						target.getLength(), target.getHeight() );
				
				double imageSimilarity = subsetImage.calculateSimilarity( target );
				if( imageSimilarity >= acceptableAccuracy ) {
					DetectionResult result = new DetectionResult( target.getName(), imageSimilarity );
					
					int endTargetX =  x + target.getLength() - 1;
					int endTargetY = y + target.getHeight() - 1;
					
					Point topLeft = new Point( x, y );
					Point topRight = new Point( endTargetX, y );
					result.setTopPoints( topLeft, topRight );
					
					Point bottomLeft = new Point( x, endTargetY );
					Point bottomRight = new Point( endTargetX, endTargetY );
					result.setBottomPoints( bottomLeft, bottomRight );
					
					results.add( result );
				}
			}
		}
		
		return results;
	}
}