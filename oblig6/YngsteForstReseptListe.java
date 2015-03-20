/**
 * Klassen YngsteForstReseptListe legger nye resepter paa toppen
 * av resept-stakken.
 * YngsteForstReseptListe er en subklasse av EnkelReseptListe.
 * @see EnkelReseptListe
 */
public class YngsteForstReseptListe extends EnkelReseptListe{
   
    /**
     * Metoden add legger resept-objekter paa toppen av
     * stakken.
     * @param  obj Resepten som skal legges inn.
     * @see Resepter.
     */
    public void add(Resept obj){
        Node n = new Node(obj);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        n.next = head;
        head = n;
    }
}
