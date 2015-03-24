public abstract class Legemiddel  {
    private String navn;
    private int nummer;
    private int pris;
    private static int last_nummer=0;
    
    public Legemiddel(String navn, int pris){
        this.navn = navn;
        this.pris = pris;
        nummer = last_nummer++;
    }

    public String getNavn() {
	return navn;
    }

    public int getNummer() {
	return nummer;
    }

    public int getPris() {
	return pris;
    }
    public static int get_last_nummer(){
        return last_nummer;
    }
}
