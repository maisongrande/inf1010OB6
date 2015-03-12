public class Lege implements Lik  {
  private String navn;

  public Boolean samme(Lege l) {
      if(l.getNavn() == navn){return true;}
      return false;
  };

    public String getNavn(){
        return navn;
    }
    public Lege(String navn){
        this.navn = navn;
    }
}
