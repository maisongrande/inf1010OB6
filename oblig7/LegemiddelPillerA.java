public class LegemiddelPillerA extends LegemiddelA implements LegemiddelPiller  {
    private int pillerPerEske;
    private int virkestoffPerPille;
    public LegemiddelPillerA(String navn, int pris, int narkotiskhet, int pillerPerEske, int virkestoffPerPille){
        super(navn,pris,narkotiskhet);
        this.pillerPerEske = pillerPerEske;
        this.virkestoffPerPille = virkestoffPerPille;
    }
    public int virkestoffPerPille(){return virkestoffPerPille;};
    public int pillerPerEske(){return pillerPerEske;};
}
