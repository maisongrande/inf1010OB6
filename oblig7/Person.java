
/**
 * Klassen Person.
 * Oppretter personer med attributene:
 * navn, foedselsnummer, adresse, postnummer.
 * Naar et personobjekt opprettes gis det et unikt
 * nummer som starter paa 0.
 */

public class Person {
    public String navn;
    public String fnummer;
    public String adresse;
    public String postnummer;
    public int loepeNr = 0;
    private static int sist_loepeNr = 0;

    public Person(String navn, String fnummer, String adresse, String postnummer) {
        this.navn = navn;
        this.fnummer = fnummer;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.loepeNr = sist_loepeNr++;
    }
    public Person(int loepeNr, String navn, String fnummer, String adresse, String postnummer) {
        this.navn = navn;
        this.fnummer = fnummer;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.loepeNr = loepeNr;
        if (loepeNr > sist_loepeNr) {
            sist_loepeNr = loepeNr;
        }
    }

    public String getPersonNummer() {
	return fnummer;
    }
}
