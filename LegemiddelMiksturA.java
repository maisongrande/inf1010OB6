public class LegemiddelMiksturA extends LegemiddelA implements LegemiddelMikstur  {
    private int virkestoffPercm3;
    private int cm3perFlaske;
    public int virkestoffPercm3(){return virkestoffPercm3;};
    public int cm3perFlaske(){return cm3perFlaske;};
    public LegemiddelMiksturA(String navn, int pris, int narkotiskhet, int cm3perFlaske, int virkestoffPercm3){
        super(navn,pris,narkotiskhet);
        this.virkestoffPercm3 = virkestoffPercm3;
        this.cm3perFlaske = cm3perFlaske;
    }
}
