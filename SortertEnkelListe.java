import java.util.*;

public class SortertEnkelListe<T extends Comparable> //& Lik>
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

        if (head == null) {
            head = tail = newNode;
            return true;
        }

        Node pos = tail;
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

