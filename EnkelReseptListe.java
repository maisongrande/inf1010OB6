public class EnkelReseptListe<T extends Resepter> {
    Node head, tail = null;


    private class Node {
	Node next;
	Resepter resept;

	Node(Node next, Resepter resept) {
	    this.next = next;
	    this.resept = resept;
	}

	Node(Resepter resept) {
	    this(null, resept);
	}
    }

}

class EldsteForstReseptListe extends EnkelReseptListe {

}

class YngsteForstReseptListe extends EnkelReseptListe {

}
