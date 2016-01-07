package list.reverse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedList {

	private LinkedNode head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public LinkedList( String... values ) {
		for ( String value : values ) {
			this.add( value );
		}
	}

	public void add( String value ) {
		LinkedNode newNode = new LinkedNode( value );

		if ( isEmpty() ) {
			head = newNode;
		} else {
			last().setNext( newNode );
		}
		
		size++;
	}
	
	public LinkedList reverse() {
		if ( size() <= 1 ) {
			return this;
		}

		LinkedNode prev = head;
		LinkedNode current = head.getNext();
		LinkedNode next = null;

		head.setNext( null );

		do {
			next = current.getNext();

			current.setNext( prev );

			if ( next == null ) {
				head = current;
				break;
			} else {
				prev = current;
				current = next;
			}

		} while ( current != null );
		
		return this;
	}
	
	public LinkedList reverseRecursive() {
		head = reverseRecursive( head );
		return this;
	}
	
	private LinkedNode reverseRecursive( LinkedNode current ) {
		
		if ( current == null || current.getNext() == null ) {
			return current;
		}
		
		LinkedNode next = current.getNext();
		current.setNext( null );
		
		LinkedNode reversed = reverseRecursive( next );
		
		next.setNext( current );
		
		return reversed;
	}

	public LinkedList reversePairs() {
		if ( this.size() <= 2 ) {
			return this;
		}

		LinkedNode prev = head;

		LinkedNode current = null;
		if ( size() % 2 == 1 ) {
			current = prev.getNext();
			head.setNext( null );
		} else {
			current = prev.getNext().getNext();
			head.getNext().setNext( null );
		}

		LinkedNode next = null;

		do {
			next = current.getNext().getNext();
			
			current.getNext().setNext( prev );

			if ( next == null ) {
				head = current;
				break;
			} else {
				prev = current;
				current = next;
			}

		} while ( current != null );
		
		return this;
	}
	
	public LinkedNode first() {
		return head;
	}

	public LinkedNode last() {
		if ( head == null ) {
			return null;
		}

		LinkedNode current = head;

		while ( current.hasNext() ) {
			current = current.getNext();
		}

		return current;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if ( isEmpty() ) {
			return "[]";
		}
		
		List<String> values = new ArrayList<>( size );
		LinkedNode current = head;
		values.add( current.getValue() );
		while ( current.hasNext() ) {
			current = current.getNext();
			values.add( current.getValue() );
		}
		
		return values.stream().collect( Collectors.joining( " -> " ) );
	}

}
