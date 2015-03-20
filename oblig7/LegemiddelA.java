public abstract class LegemiddelA extends Legemiddel  {
    private int narkotiskhet;
    public LegemiddelA(String navn, int pris, int narkotiskhet){
        super(navn,pris);
        this.narkotiskhet = narkotiskhet;
    }
    
    public int getNarkotiskhet() {
	return narkotiskhet;
    }

}
