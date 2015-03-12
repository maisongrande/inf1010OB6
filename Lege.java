public class Lege implements Lik, Comparable {
    private String navn;

    public Boolean samme(Object lege) {
        if (lege instanceof Lege) {
            Lege l = (Lege)lege;
            if(l.getNavn().equals(navn)){return true;}
        }
        return false;
    };

    public int compareTo(Object lege) {
        if (lege instanceof Lege) {
            Lege l = (Lege)lege;
            return l.getNavn().compareTo(navn);
        }
        return -1;
    }

    public String getNavn(){
        return navn;
    }
    public Lege(String navn){
        this.navn = navn;
    }
}
