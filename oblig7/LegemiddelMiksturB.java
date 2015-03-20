public class LegemiddelMiksturB extends LegemiddelB implements LegemiddelMikstur  {
    private int virkestoffPercm3;
    private int cm3perFlaske;
    public int virkestoffPercm3(){return virkestoffPercm3;};
    public int cm3perFlaske(){return cm3perFlaske;};
    public LegemiddelMiksturB(String navn, int pris, int vanedannendehet, int cm3perFlaske, int virkestoffPercm3){
        super(navn,pris,vanedannendehet);
        this.virkestoffPercm3 = virkestoffPercm3;
        this.cm3perFlaske = cm3perFlaske;
    }
}

