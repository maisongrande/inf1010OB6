public abstract class LegemiddelB extends Legemiddel  {
    private int vanedannendehet;
    public LegemiddelB(String navn, int pris, int vanedannendehet){
        super(navn,pris);
        this.vanedannendehet = vanedannendehet;
    }
    public int getVanedannendehet() {
	return vanedannendehet;
    }
}
