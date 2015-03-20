public abstract class Resept {
    public int nummer;
    public Legemiddel legemiddel;
    public Lege lege;
    public Person pasient;
    public int reit;
    public static int sist_nummer=0;
    public Resept(Legemiddel legemiddel, Lege lege, Person pasient, int reit){
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.pasient = pasient;
        this.reit = reit;
        nummer = ++sist_nummer;
    }
}
