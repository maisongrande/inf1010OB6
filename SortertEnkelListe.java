import java.util.*;

/**
 * Klassen SortertEnkelListe oppretter en enkel-lenket liste
 * hvor hver node inneholder peker til alfabetisk-sortert objekt.
 * Objekter i listen forutsetter at de er av klasser som implementerer
 * interaface Comparable og Lik.
 * SortertEnkelListe implemeneterer Iterable-interface.
 * @see Comaparable
 * @see Lik
 * @see Iterable
 */
public class SortertEnkelListe<T extends Comparable & Lik>
    implements Iterable<T> {

    Node head, tail = null;

    /**
     * Metoden add legger inn elementer i listen avhengig av elementets
     * alfabetiske vekt. 
     * @param obj Objektet/Elementet som skal legges i listen.
     * @param s Medfoelgende vilkaarlig streng.
     * @return true/false Avhengig av om metoden lykkes.
     */
    public boolean add(T obj, String s) {
        Node newNode = new Node(obj,s);

        if (head == null) {
            head = tail = newNode;
            return true;
        }

        Node pos = head;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.obj.compareTo(newNode.obj) <= 0) {
                pos = tmp;
            }
            tmp = tmp.next;
        }

        if (pos == head && pos.obj.compareTo(newNode.obj) >= 0) {
            newNode.next = pos;
            head = newNode;
        } else {
            newNode.next = pos.next;
            pos.next = newNode;
        }
        if (pos == tail) {
            tail = newNode;
        }
        return true;
    }

    /**
     * Metoden get returnerer objektet bundet til id-strengen s.
     * @param s Id-til objektet i listen.
     * @return Objektet med ID = s
     */
    public T get(String s) {
        Node tmp;

        for (tmp = head; tmp != null; tmp = tmp.next) {
            if((tmp.id).equals(s))
                return tmp.obj;
        }
        throw new NoSuchElementException();
    }


    /**
     * Metoden iterator returnerer ett nytt iterator-objekt
     * som kan nyttes til bl.a for-each.
     * @return Iterator-objekt
     */
    public Iterator<T> iterator() {
        return new EnkelListeIterator();
    }


    /**
     * Klassen Node oppretter et nytt Node-objekt 
     * som skal lenkes inn i en liste.
     */
    private class Node {
        Node next = null;
        T obj;
        String id;

	/**
	 * Konstruktoer oppretter en ny node som inneholder
	 * objekt, id og neste-peker satt til null.
	 * @param obj Objektet noden skal inneholde.
	 * @param id Streng med nodens ID i listen.
	 */
        Node(T obj, String id){
            this.obj = obj;
            this.id = id;
        }
    }


    /**
     * Klassen EnkelListeIterator oppretter objekter som muligjoer
     * iterasjoner gjennom lenkelisten bassert paa interfacet 
     * Iterator.
     * @see Iterator
     */
    private class EnkelListeIterator implements Iterator<T> {
        private Node nextPtr = head;

	
	/**
	 * Metoden hasNext sjekker at det finnes et neste-element i listen.
	 * @return true/fals Avhengig av om det finnes eller ikke. 
	 */
        public boolean hasNext() {
            return nextPtr != null ;
        }

	
	/**
	 * Metoden next returnerer objektet som befinner seg i neste 
	 * node i listen.
	 * @return objektet.
	 */
        public T next() {
            Node retObj = nextPtr;
            nextPtr = nextPtr.next;
            return retObj.obj;
        }

	
	/**
	 * Metoden remove
	 * Ikke implementert
	 * @throws UnsupportedOperationException
	 */
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }
}

