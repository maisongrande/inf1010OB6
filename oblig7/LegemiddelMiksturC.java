public class LegemiddelMiksturC extends LegemiddelC implements LegemiddelMikstur  {
  private int virkestoffPercm3;
    private int cm3perFlaske;
    public int virkestoffPercm3(){return virkestoffPercm3;};
    public int cm3perFlaske(){return cm3perFlaske;};
    public LegemiddelMiksturC(String navn, int pris, int cm3perFlaske, int virkestoffPercm3){
        super(navn,pris);
        this.virkestoffPercm3 = virkestoffPercm3;
        this.cm3perFlaske = cm3perFlaske;
    }
}
