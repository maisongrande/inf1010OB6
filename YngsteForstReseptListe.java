public class YngsteForstReseptListe extends EnkelReseptListe{
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
