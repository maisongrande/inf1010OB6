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
}
