public class BlaResept extends Resept {
  private int pris=0;
   
  public BlaResept(int nummer, Legemiddel legemiddel, Lege lege, Person pasient, int reit){
      super(legemiddel, lege, pasient, reit);
  }
}
