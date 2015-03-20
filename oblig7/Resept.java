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

    public int getNummer() {return nummer;}
    public int getReit() {return reit;}
    public String getLege() {
	return lege.getNavn();
    }
    public Legemiddel getLegemiddel() {
	return legemiddel;
    }

    public Long getPersonNummer() {
	return pasient.getPersonNummer();
    }
}
