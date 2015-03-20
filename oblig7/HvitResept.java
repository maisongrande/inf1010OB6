public class HvitResept extends Resept {
    private int pris;
    public HvitResept(int nummer, Legemiddel legemiddel, Lege lege, Person pasient, int reit, int pris){
        super(legemiddel, lege, pasient, reit);
        this.pris = pris;
    }
}
