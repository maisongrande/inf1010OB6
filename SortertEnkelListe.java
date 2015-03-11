import java.util.*;

public class SortertEnkelListe<T extends Comparable & Lik>
    implements Iterable {

    Node head, tail = null;
    
    public boolean add(T obj, String s) {
	Node newNode = new Node(obj,s);
	Node tmp = head;
	
	if (head == null) {
	    head = tail = newNode;
	    return true;
	}

	while (tmp != null) {

	    if (newNode.obj.compareTo(tmp.obj) < 0) {
		newNode.next = tmp;
		if (tmp == head) 
		    head = newNode;	
		return true;
	    }	    
	    tmp = tmp.next; 
	}
	tail = newNode;
	tmp.next = newNode;

	return true;
    }

    public T get(String s) {
	Node newNode;

	for (newNode = head; !newNode.id.equals(s); newNode = newNode.next);
	
	return newNode == null?null:newNode.obj;	
    }


    
    public Iterator<T> iterator() {
	return new EnkelListeIterator();
    }

    
    private class Node {
	Node next = null;
	T obj;
	String id;
	
	Node(T obj, String id){
	    this.obj = obj;
	    this.id = id;
	}
    }

    private class EnkelListeIterator implements Iterator<T> {
	private Node nextPtr = head;
	
	public boolean hasNext() {
	    return nextPtr.next != null ;
	}

	public T next() {
	    nextPtr = nextPtr.next;
	    return nextPtr.obj;
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}

