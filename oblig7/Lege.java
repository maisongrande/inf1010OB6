public class Lege implements Lik, Comparable {
    private String navn;
    public int avtaleNummer = 0;

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
            return navn.compareToIgnoreCase(l.getNavn());
        }
        return -1;
    }

    public String getNavn(){
        return navn;
    }
    public String toString(){
        return navn;
    }
    public Lege(String navn){
        this.navn = navn;
    }
    public Lege(String navn, int a){
        this.navn = navn;
        this.avtaleNummer = a;
    }
}
