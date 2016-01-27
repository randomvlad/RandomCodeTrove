package array.bliffoscope;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BliffoscopeMain {

	public static void main( String[] args ) throws IOException {

		Image targetShip = loadImage( "starship", "data/Starship.blf" );
		Image targetTorpedo = loadImage( "slime torpedo", "data/SlimeTorpedo.blf" );
		Image spaceTerrain = loadImage( "space", "data/TestData.blf" );

		BliffoscopeDetector detector = BliffoscopeDetector.getInstance();
		// detector.setAccuracy( 0.71 );

		List<DetectionResult> results = new ArrayList<>();
		results.addAll( detector.detect( spaceTerrain, targetShip ) );
		results.addAll( detector.detect( spaceTerrain, targetTorpedo ) );

		if ( !results.isEmpty() ) {
			Collections.sort( results, Collections.reverseOrder() );
			
			System.out.println( "Found " + results.size() + " targets:" );
			results.stream().forEach( r -> System.out.println( r ) );
		} else {
			System.out.println( "No targets detected" );
		}
	}

	private static Image loadImage( String imageName, String fileName ) throws IOException {
		
		Path path = Paths.get( BliffoscopeMain.class.getResource( fileName ).getPath() );
		List<String> lines = Files.lines( path ).collect( Collectors.toList() );
		
		char[][] imageGrid = new char[ lines.size() ][];
		for ( int i = 0; i < lines.size(); i++ ) {
			imageGrid[ i ] = lines.get( i ).toCharArray();
		}

		return new Image( imageName, imageGrid );
	}
}