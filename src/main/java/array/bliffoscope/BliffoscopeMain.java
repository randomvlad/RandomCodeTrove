package array.bliffoscope;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
 
/**
 * @author Vlad Poskatcheev
 */
public class BliffoscopeMain {
	
	public static void main( String[] args ) {
		Image targetShip = loadImageFrom( "data/Starship.blf" );
		Image targetTorpedo = loadImageFrom( "data/SlimeTorpedo.blf" );
		Image spaceTerrain = loadImageFrom( "data/TestData.blf" );
		if( targetShip == null || targetTorpedo == null || spaceTerrain == null ) {
			return;
		}
		
		List<Image> targets = new ArrayList<Image>();
		targetShip.setName( "starship" );
		targets.add( targetShip );
		targetTorpedo.setName( "slime torpedo" );
		targets.add( targetTorpedo );
		
		BliffoscopeDetector detector = BliffoscopeDetector.getInstance();
		// detector.setAcceptableAccuracy( 0.71 );
		List<DetectionResult> results = new ArrayList<DetectionResult>();
		for( Image target : targets ) {
			results.addAll( detector.detect( spaceTerrain, target ) );
		}
		
		if( ! results.isEmpty() ) {
			Collections.sort( results );
			Collections.reverse( results );
			
			System.out.println( "Found (" + results.size() + ") targets:" );
			for( DetectionResult result : results ) {
				System.out.println( result.toString() );
			}
		} else {
			System.out.println( "No targets detected" );
		}
	}
	
	private static Image loadImageFrom( String fileName ) {
		List<String> lines = new ArrayList<>();
		
		BufferedReader readerIn = null;
		try {
			readerIn = new BufferedReader( new FileReader(fileName) );
			String line = readerIn.readLine();
			while( line != null ) {
				lines.add( line );
				line = readerIn.readLine();
			}
		} catch( Exception e ) {
			System.out.println( "Error: unable to load: " + fileName );
			return null;
		} finally {
			try {
				if( readerIn != null ) {
					readerIn.close();
				}
			} catch ( IOException ignore ) {}
		}
		
		char[][] imageGrid = new char[ lines.size() ][];
		for( int line = 0; line < lines.size(); line++ ) {
			imageGrid[ line ]  = lines.get( line ).toCharArray();
		}
		
		return new Image( imageGrid );
	}
}