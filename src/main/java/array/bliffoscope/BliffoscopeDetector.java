package array.bliffoscope;

import java.util.*;
import java.awt.Point;

public class BliffoscopeDetector {
	
	public final static double DEFAULT_ACCURACY = 0.75;
	
	public static BliffoscopeDetector getInstance() {
		return new BliffoscopeDetector( DEFAULT_ACCURACY );
	}
	
	private double accuracy; 
	
	private BliffoscopeDetector( double accuracy ) {
		this.accuracy = accuracy;
	}
	
	/**
	 * @param value percentage must be within 0 to 1 range
	 * @see #detect(Image, Image)
	 */
	public void setAccuracy( double value ) {
		if( value >= 0 && value <= 1 ) {
			accuracy = value; 
		}
	}
	
	/**
	 * @return Detection accuracy percentage within 0 to 1 range
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Detects all potential instances of a target image in source image. 
	 * Detection allows for approximation of target image. An accuracy percentage 
	 * controls how exact a match has to be.
	 * 
	 * @return A non-null list of detection results
	 * @see #setAccuracy(double)
	 * @throws NullPointerException if either source or target are null
	 */
	public List<DetectionResult> detect( Image source, Image target ) {
		List<DetectionResult> results = new ArrayList<>();
		
		int xEnd = source.getLength() - target.getLength();
		int yEnd = source.getHeight() - target.getHeight();
		
		for( int x = 0; x <= xEnd; x++ ) {
			for( int y = 0; y <= yEnd; y++ ) {
				Image subsetImage = source.createSubset( x, y, target.getLength(), target.getHeight() );
				
				double imageSimilarity = subsetImage.calculateSimilarity( target );
				if( imageSimilarity >= accuracy ) {
					DetectionResult result = new DetectionResult( target.getName(), imageSimilarity );
					
					int endTargetX = x + target.getLength() - 1;
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