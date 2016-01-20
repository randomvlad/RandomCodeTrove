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
		
		LinkedNode prev = null;
		LinkedNode current = head;
		LinkedNode next = null;
		
		while ( current != null ) {
			next = current.getNext();
			current.setNext( prev );
			
			prev = current;
			current = next;
		}
		
		head = prev;
		
		return this;
	}

	public LinkedList reverseRecursive() {
		head = reverseRecursive( head );
		return this;
	}

	private LinkedNode reverseRecursive( LinkedNode current ) {

		if ( current == null || ! current.hasNext() ) {
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
		LinkedNode next = null;
		
		if ( size() % 2 == 1 ) {
			current = prev.getNext();
			prev.setNext( null );
		} else {
			current = prev.getNext().getNext();
			prev.getNext().setNext( null );
		}
		
		while ( current != null ) {
			next = current.getNext().getNext();
			current.getNext().setNext( prev );
			
			prev = current;
			current = next;
		}
		
		head = prev;
		
		return this;
	}

	public LinkedList reverseAlternateK( int k ) {
		if ( k > 1 ) {
			head = reverseAlternateK( head, k );
		}

		return this;
	}
	
	private LinkedNode reverseAlternateK( LinkedNode node, int k ) {
		if ( node == null || ! node.hasNext() ) {
			return node;
		}
		
		LinkedNode prev = null;
		LinkedNode current = node;
		LinkedNode next = null;

		int reversed = 0;
		
		while ( current != null && reversed < k ) {
			next = current.getNext();
			current.setNext( prev );
			
			prev = current;
			current = next;
			reversed++;
		}
		
		node.setNext( current );

		int skip = 0;
		while ( current != null && skip < ( k - 1 ) ) {
			current = current.getNext();
			skip++;
		}
		
		if ( current != null ) {
			current.setNext( reverseAlternateK( current.getNext(), k ) );
		}
		
		return prev; // new head of the list
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
		LinkedNode current = head;
		List<String> values = new ArrayList<>( size );
		while ( current != null ) {
			values.add( current.getValue() );
			current = current.getNext();
		}
		
		return values.stream().collect( Collectors.joining( " -> " ) );
	}

}
