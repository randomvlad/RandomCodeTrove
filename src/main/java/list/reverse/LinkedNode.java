package list.reverse;

public class LinkedNode {

	private String value;
	private LinkedNode next;
	
	public LinkedNode( String value ) {
		this( value, null );
	}

	public LinkedNode( String value, LinkedNode next ) {
		this.setValue( value );
		this.setNext( next );
	}

	public String getValue() {
		return value;
	}

	public void setValue( String value ) {
		this.value = value;
	}

	public boolean hasNext() {
		return this.getNext() != null;
	}

	public LinkedNode getNext() {
		return next;
	}

	public void setNext( LinkedNode next ) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value;
	}

}
