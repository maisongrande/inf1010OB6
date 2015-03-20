import java.util.*;

/**
 * EnkelReseptListe klassen haandterer innsetting av resepter
 * inn i lenket resept-liste.
 */
public class EnkelReseptListe implements Iterable<Resept> {
    Node head, tail = null;

    /**
     * Klassen Node oppretter Node-objekter med peker til
     * et resept-objekt og peker til null eller spesifisert Node objekt.
     */
    class Node {
        Node next;
        Resept resept;

        /**
         * Konstruktoer for Node-objekt.
         * @param next plassholder for neste node
         * @param resept Resepten noden skal peke til.
         */
        Node(Node next, Resept resept) {
            this.next = next;
            this.resept = resept;
        }

        /**
         * Konstruktoer
         * @param resept Resepten noden skal peke til.
         */
        Node(Resept resept) {
            this(null, resept);
        }
    }

    /**
     * Klassen ERLIterator oppretter og initialiserer et iterator-
     * objekt som kan iterere fra starten av lenketlisten til slutten.
     * @see Iterator Interface
     */
    class ERLIterator implements Iterator<Resept> {
        private Node node = head;

        /**
         * Metoden hasNext returnerer true saa lenge det finnes noder
         * i listen.
         * @return true/false
         */
        public boolean hasNext() {
            return node == null ? false : true;
        }

        /**
         * Metoden next returnerer resepter saa lenge disse finnes i listen.
         * @return r Resept
         */
        public Resept next() {
            Resept r = node.resept;
            node = node.next;
            return r;
        }

        /**
         * Metoden remove er ikke implementert.
         * @throws UnsupportedOperationException
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /** 
     * Metoden add legger til et nytt reseptobjekt til lenkelisten av
     * resepter.
     * @param obj Resepten som skal legges inn
     */
    public void add(Resept obj) {
        Node n = new Node(obj);
        if(head == null) {
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    /**
     * Metoden get returerer resepten i noden spesifisert som argument til 
     * kallet.
     * @param id Reseptnummeret
     * @return n Resepten med match paa nummer.
     * @throws NoSuchElementException
     * @see Resept
     */
    public Resept get(int id){
        Node n = head;
        while(n != null) {
            if (n.resept.nummer == id) {
                return n.resept;
            }
            n = n.next;
        }
        throw new NoSuchElementException();
    }

    /**Metoden Iterator oppretter ett iterator-objekt.
     * @return ERLIterator objekt av typen ERLIterator
     */
    public Iterator<Resept> iterator(){
        return new ERLIterator();
    }
}

