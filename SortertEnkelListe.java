import java.util.*;

public class SortertEnkelListe<T extends Comparable & Lik>
    implements Iterable<T> {

    Node head, tail = null;


    /* HJELPE-METODE MIDLERTIDIG */
    public void printNodes() {
	Node tmp = head;

	while (tmp != null) {
	    System.out.println(tmp.obj);
	    tmp = tmp.next;
	}
    }
    /*============================*/
    
    public boolean add(T obj, String s) {
        Node newNode = new Node(obj,s);
        Node tmp = head;
	Node prev = null;
	
        if (head == null) {
            head = tail = newNode;
            return true;
        }

        while (tmp != null) {
	    if (newNode.obj.compareTo(tmp.obj) < 0) {
                if (tmp == head) {
		    newNode.next = tmp;
		    head = newNode;
		} else {
		    newNode.next = tmp;
		    prev.next = newNode;
       		}
		return true;
	    }	    
	    prev = tmp;
	    tmp = tmp.next;   
        }

	tail.next = newNode;
        tail = newNode;

        return true;
    }

    
    public T get(String s) {
        Node tmp;

        for (tmp = head; tmp != null; tmp = tmp.next) {
	    if((tmp.id).equals(s))
		return tmp.obj;
	}
	throw new NoSuchElementException();
	
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
	    return nextPtr != null ;
	}

	public T next() {
	    Node retObj = nextPtr;
	    nextPtr = nextPtr.next;
	    return retObj.obj;
	}

	public void remove() {
	    throw new UnsupportedOperationException("Not implemented.");
	}
    }
}

