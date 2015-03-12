public class Lege implements Lik, Comparable {
    private String navn;

    public Boolean samme(Lege l) {
        if(l.getNavn().equals(navn)){return true;}
        return false;
    };

    public int compareTo(Lege l) {
        return l.getNavn.compareTo(navn);
    }

    public String getNavn(){
        return navn;
    }
    public Lege(String navn){
        this.navn = navn;
    }
}
