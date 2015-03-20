
/**
 * Klassen Personer.
 * Oppretter personer med attributene:
 * navn, foedselsnummer, adresse, postnummer.
 * Naar et personobjekt opprettes gis det et unikt
 * nummer som starter paa 0.
 */

public class Personer {
    private String navn;
    private long fnummer;
    private String adresse;
    private int postnummer;
    private int loepeNr = 0;

    public Personer(String navn, long fnummer, String adresse, int postnummer) {
	this.navn = navn;
	this.fnummer = fnummer;
	this.adresse = adresse;
	this.postnummer = postnummer;
	this.loepeNr = ++loepeNr;
    }
}
