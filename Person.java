public class Person  {
  private String navn;
  private int personnummer;
  private int nummer;
  private static int sist_nummer=0;

  public Person(String navn, int personnummer){
    this.navn = navn;
    this.personnummer = personnummer;
    nummer = ++sist_nummer;
  }
}
