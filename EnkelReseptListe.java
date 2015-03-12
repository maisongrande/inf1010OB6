import java.util.*;
public class EnkelReseptListe implements Iterable {
    Node head, tail = null;

    class Node {
        Node next;
        Resept resept;

        Node(Node next, Resept resept) {
            this.next = next;
            this.resept = resept;
        }

        Node(Resept resept) {
            this(null, resept);
        }
    }

    class ERLIterator implements Iterator {
        private Node node = head;

        public boolean hasNext() {
            return node == null ? false : true;
        }

        public Resept next() {
            Resept r = node.resept;
            node = node.next;
            return r;
        }

        public void remove() {}
    }

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

    public Resept get(int id){
        Node n = head;
        while(n != null) {
            if (n.resept.nummer == id) {
                return n.resept;
            }
            n = n.next;
        }
        return null;
    }

    public Iterator iterator(){
        return new ERLIterator();
    }
}

