package string.braces;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracesTest {

	@Test
	public void testBraces() {
		
		BracesValidator validator = new BracesValidator();
		
		assertTrue( validator.validate( "{ [i] (love) [lamp] }" ).isValid() );
		
		assertTrue( validator.validate( "[({})]" ).isValid() );
		
		assertTrue( validator.validate( "(hi) [there[!]] {waffles}" ).isValid() );
		
		String value = "[";
		Result result = validator.validate( value );
		assertFalse( result.isValid() );
		assertEquals( 
				Result.getErrorMessage( value, new Brace( '[', 0 ) ), 
				result.getValidMessage() 
		);
		
		value = "[(}";
		result = validator.validate( value );
		assertFalse(  result.isValid() );
		assertEquals( 
				Result.getErrorMessage( value, new Brace( '}', 2 ) ),
				result.getValidMessage() 
		);
		
		value = "carelessly )bracing about";
		result = validator.validate( value );
		assertFalse(  result.isValid() );
		assertEquals( 
				Result.getErrorMessage( value, new Brace( ')', 11 ) ),
				result.getValidMessage() 
		);
	}

}


