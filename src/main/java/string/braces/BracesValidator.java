package string.braces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class BracesValidator {
	
	private static Map<Character, Character> startEndDefs;

	public BracesValidator() {
		init();
	}
	
	private void init() {
		if ( startEndDefs == null ) {
			startEndDefs = new HashMap<>();
			startEndDefs.put( '[', ']' );
			startEndDefs.put( '(', ')' );
			startEndDefs.put( '{', '}' );
		}
	}
	
	public boolean isBrace( char value ) {
		return value == '[' || value == ']' || value == '(' || value == ')' || value == '{' || value == '}';
	}
	
	public Result validate( String value ) {
		
		Stack<Brace> opened = new Stack<>(); 
		
		Result result = new Result( value );
		
		for ( int i = 0; i < value.length(); i++ ) {
			
			char character = value.charAt( i );
			if ( ! isBrace( character ) ) {
				continue;
			}
			
			Brace brace = new Brace( character, i );
			
			if ( startEndDefs.containsKey( brace.value ) ) {
				opened.push( brace );
				continue;
			}

			if ( opened.isEmpty() ) {
				result.setBraceInError( brace );
				break;
			}

			Brace lastOpenBrace = opened.pop();
			
			char expectedCloseBrace = startEndDefs.get( lastOpenBrace.value );
			if ( brace.value != expectedCloseBrace ) {
				result.setBraceInError( brace );
				break;
			}
		}
		
		if ( result.isValid() && ! opened.isEmpty() ) {
			result.setBraceInError( opened.pop() );
		}

		return result;
	}
}