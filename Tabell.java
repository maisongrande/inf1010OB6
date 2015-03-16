import java.util.*;

/**
 * Klassen AbstraktTabell lagrer alle elementene i en array, 
 * og arrayens lengde oppgis som parameter til konstruktøren.
 * @see AbstraktTabell
 * @see Iterable
 */
public class Tabell<T> implements AbstraktTabell<T>, Iterable<T>  {
    private T[] array;

    /**
     * Konstruktoer.
     * @param i Stoerrelsen paa Array/Tabell.
     */
    Tabell(int i) {
	array = (T[])new Object[i];
    }

    
    /**
     * Add legger et nytt objekt av klassen T paa indeks i
     * @param i Indeksen objektet skal plasseres i.
     * @param obj Objektet som skal plasseres.
     * @return true/false Indikerer om objektet ble plassert eller ikke. 
     */
    public boolean add(int i, T obj) {

	if (array[i] != null || i > array.length)
	    return false;

	array[i] = obj;
	return true;
    }

    /**
     * Metoden get returnerer objektet som befinner seg paa indeksen som
     * legges ved kallet.
     * @param i Indeksen til elementet som skal returneres.
     * @return null Hvis indeksen er stoerre enn arrayets faktiske str.
     * @param T Objektet paa plassen i.
     */
    public T get(int i) {
	if (i > array.length)
	    return null;
	
	return array[i];
    }

    /**
     * Metoden Iterator oppretter, initialiserer, og returnerer et 
     * iterator-objekt som kan  brukes av bl.a for-each metoden.
     * @return iterator-objekt 
     * @see Iterator-interface
     * @see TabellIterator
     */
    public Iterator<T> iterator() {
	return new TabellIterator();
    }

    /**
     * Private klassen TabellIterator spawner en iterator
     * for klassen Tabell, basert paa interface Iterator.
     *
     */
    private class TabellIterator implements Iterator<T> {
	private int pos = 0;
	
	/**
	 * Metoden hasNext returnerer true/false bassert paa om
	 * det er flere elementer i arrayet.
	 * @return true/false Avhengig om det finnes et neste-elemement.
	 */
	public boolean hasNext() {
	    return pos < array.length;
	}

	/**
	 * Metoden next returnerer det neste elementet i array/tabell
	 * hvis det eksisterer.
	 * @return objektet i neste posisjon.
	 */
	public T next() {
	    return array[pos++];
	}

	/**
	 * remove. Ikke implementert
	 * @throws UnsupportedOperationEception
	 */
	public void remove() {
	    throw new UnsupportedOperationException();	    
	}
    }
}
