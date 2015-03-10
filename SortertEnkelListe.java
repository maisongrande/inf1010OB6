public class SortertEnkelListe<T implements Comperable & Lik>
    implements Iterable {

    Node head, tail = null;
    
    public boolean add(T obj) {
	Node newNode = new Node(obj);
	Node tmp = head;
	
	if (head == null) {
	    head = tail = newNode;
	    return true;
	}

	while (tmp != null) {

	    if (newNode.compareTo(tmp.obj) < 0) {
		newNode.next = tmp;
		if (tmp == head) 
		    head = newNode;		
		return true;
	    }	    
	    tmp = tmp.next; 
	}
	tail = newNode;
	tmp.next = newNode;
    }

    
    private class Node {
	Node next = null;
	T obj;

	Node(Node next, T obj){
	    this.next = next;
	    this.obj = obj;
	}	
    }

    private class EnkelListeIterator implements Iterator<T> {

	private int i = 0;
	
	public boolean hasNext() {
	    return pos < array.length;
	}

	public T next() {
	    return array[pos++];
	}

	public void remove() {}
    }
}
								  e
