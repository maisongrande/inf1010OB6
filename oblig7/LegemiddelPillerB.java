public class LegemiddelPillerB extends LegemiddelB implements LegemiddelPiller  {
    private int pillerPerEske;
    private int virkestoffPerPille;
    public LegemiddelPillerB(String navn, int pris, int vanedannendehet, int pillerPerEske, int virkestoffPerPille){
        super(navn,pris,vanedannendehet);
        this.pillerPerEske = pillerPerEske;
        this.virkestoffPerPille = virkestoffPerPille;
    }
    public int virkestoffPerPille(){return virkestoffPerPille;};
    public int pillerPerEske(){return pillerPerEske;};
}
