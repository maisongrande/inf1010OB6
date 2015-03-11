import java.util.*;

public class Tabell<T> implements AbstraktTabell<T>, Iterable<T>  {
    private T[] array;

    Tabell(int i) {
	array = (T[])new Object[i];
    }

    public boolean add(int i, T obj) {

	if (array[i] != null || i > array.length)
	    return false;

	array[i] = obj;
	return true;
    }

    public T get(int i) {
	if (i > array.length)
	    return null;
	
	return array[i];
    }

    public Iterator<T> iterator() {
	return new TabellIterator();
    }
    
    private class TabellIterator implements Iterator<T> {

	private int pos = 0;
	
	public boolean hasNext() {
	    return pos < array.length;
	}

	public T next() {
	    return array[pos++];
	}

	public void remove() {
	    throw new UnsupportedOperationException();	    
	}
    }
}
