
public class Leger implements Lik, KommuneAvtale {
    private String navn;
    private int avtaleNr;

    Leger(String navn) {
	this.navn = navn;
    }

    Leger(String navn, int avtaleNr) {
	this.navn = navn;
	this.avtaleNr = avtaleNr;
    }

    public void setAvtaleNr(int avtaleNr) {
	this.avtaleNr = avtaleNr;
    }
    
    public boolean samme(String navn) {
	return this.navn == navn?true:false;
    }

    public int avtaleNummer(){
	return avtaleNr;
    }
}
