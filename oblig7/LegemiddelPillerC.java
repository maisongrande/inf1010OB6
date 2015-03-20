public class LegemiddelPillerC extends LegemiddelC implements LegemiddelPiller
{
    private int pillerPerEske;
    private int virkestoffPerPille;
    public LegemiddelPillerC(String navn, int pris, int pillerPerEske, int virkestoffPerPille){
        super(navn,pris);
        this.pillerPerEske = pillerPerEske;
        this.virkestoffPerPille = virkestoffPerPille;
    }
    public int virkestoffPerPille(){return virkestoffPerPille;};
    public int pillerPerEske(){return pillerPerEske;};
}
