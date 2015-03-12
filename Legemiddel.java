public abstract class Legemiddel  {
  private String navn;
  private int nummer;
  private int pris;
    private static int last_nummer=0;
    
    public Legemiddel(String navn, int pris){
        this.navn = navn;
        this.pris = pris;
        nummer = ++last_nummer;
    }
}
