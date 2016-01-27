package array.bliffoscope;

import java.awt.Point;

public class DetectionResult implements Comparable<DetectionResult> {
	
	private String detectedTarget;
	
	private double accuracy;
	
	private Point topLeft;
	private Point topRight;
	private Point bottomLeft;
	private Point bottomRight;
	
	DetectionResult( String detectedTarget, double accuracy ) {
		this.detectedTarget = detectedTarget;
		this.accuracy = accuracy;
	}

	public void setTopPoints( Point topLeft, Point topRight ) {
		this.topLeft = topLeft;
		this.topRight = topRight;
	}
	
	public void setBottomPoints( Point bottomLeft, Point bottomRight ) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
	
	/**
	 * @return Name of the detected target
	 */
	public String getDetectedTarget() {
		return detectedTarget;
	}
	
	/**
	 * @return 	A number between 0 and 1. The closer the number to 1, 
	 * 			the more accurate is the detection result.
	 */
	public double getAccuracy() {
		return accuracy;
	}
	
	/**
	 * @return 	An array of two point coordinates specifying the location
	 * 			of the top boundary portion of the target. First point is 
	 * 			the Top Left coordinate, the second is the Top Right 
	 *		 	coordinate. 
	 */
	public Point[] getTopPoints() {
		return new Point[] { topLeft, topRight };
	}

	/**
	 * @return 	An array of two point coordinates specifying the location
	 * 			of the bottom boundary portion of the target. First point is 
	 * 			the Bottom Left coordinate, the second is the Bottom Right 
	 *		 	coordinate. 
	 */	
	public Point[] getBottomPoints() {
		return new Point[] { bottomLeft, bottomRight };
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append( getDetectedTarget() );
		int simplePercent = (int)(getAccuracy() * 100);
		sb.append( " (" + simplePercent + "%) detected in area [ " );
		sb.append( getPointDisplay(topLeft) + ", ");
		sb.append( getPointDisplay(topRight) + ", " );
		sb.append( getPointDisplay(bottomLeft) + ", ");
		sb.append( getPointDisplay(bottomRight) + " ]");
		
		return sb.toString();
	}
	
	private String getPointDisplay( Point point ) {
		int x = (int)point.getX();
		int y  = (int)point.getY();
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * @throws NullPointerException if that is null
	 */
	@Override
	public int compareTo( DetectionResult that ) {
		double accuracyComparision = this.accuracy - that.accuracy;
		
		if( accuracyComparision > 0 ) {
			return 1;
		} else if( accuracyComparision < 0 ) {
			return -1;
		} else {
			return this.detectedTarget.compareTo( that.detectedTarget );
		}
	}
}