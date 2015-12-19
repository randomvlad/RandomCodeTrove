package string.braces;

class Result {
		
	private boolean valid;
	private Brace braceInError;
	private String value;
	
	public Result( String value ) {
		this.valid = true;
		this.value = value;
	}
	
	public void setBraceInError( Brace brace ) {
		this.braceInError = brace;
		this.valid = false;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public Brace getBraceInError() {
		return braceInError;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getValidMessage() {
		return valid ? "YES" : Result.getErrorMessage( value, braceInError );
	}
	
	public static String getErrorMessage( String value, Brace brace ) {
		
		StringBuilder pad = new StringBuilder();
		for ( int i = 0; i < brace.index; i++ ) {
			pad.append( " " );
		}
		
		return value + System.lineSeparator() + 
				pad.toString() +  "^ ERROR: brace " + brace.value + " is not closed";
	}
}