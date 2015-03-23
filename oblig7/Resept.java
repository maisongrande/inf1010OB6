public abstract class Resept {
    public int nummer;
    private Legemiddel legemiddel;
    private Lege lege;
    private Person pasient;
    private int reit;
    private static int sist_nummer=0;
    public Resept(Legemiddel legemiddel, Lege lege, Person pasient, int reit){
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.pasient = pasient;
        this.reit = reit;
        nummer = ++sist_nummer;
    }

    public static int get_sist_nummer(){
        return sist_nummer;
    }
    public int getNummer() {return nummer;}
    public int getReit() {return reit;}
    public Lege getLege() {
        return lege;
    }
    public Legemiddel getLegemiddel() {
        return legemiddel;
    }

    public Person getPasient() {
        return pasient;
    }
    public Boolean hentResept() {
        if (reit > 0) {
            reit--;
            return true;
        } else {
            return false;
        }
    }
}

