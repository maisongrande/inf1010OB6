import java.util.*;
import java.io.*;
class Eresept {
    Tabell<Person> personer = new Tabell<Person>(100000);
    EnkelReseptListe resepter = new EnkelReseptListe();
    SortertEnkelListe<Lege> leger = new SortertEnkelListe<Lege>();
    Tabell<Legemiddel> legemidler = new Tabell<Legemiddel>(100000);


    /**
       Metoden save
       Skriver all informasjon om leger og respter til fil.
       @param filnavn Filnavnet hvor data skal lagres.
       @throws IOException
     */
    public void save(String filnavn) {
	try {
	    FileWriter fil = new FileWriter(new File(filnavn));
	    fil.write(print());
	    fil.close();
	} catch (IOException e ) {
	    System.out.println(e);
	}
    }


    /**
       Metoden load
       Laster inn fil med data og fordeler disse til riktig type 
       metode basert pa noekkelord startende med #.
       Datatyper:
       - Personer.
       - Legemidler.
       - Leger.
       - Resepter.
       
       @param filnavn Navnet paa filen som skal lastes inn.
       @throws IOException.
     */
    public void load(String filnavn) {
	Scanner fil;
	try {
	    fil = new Scanner(new File(filnavn));
	} catch (IOException e) {
	    System.out.println(e);
	    return;
	}
	String[] line;
	String input;
	String modus = "tut";
	while (fil.hasNextLine()){
	    input = fil.nextLine();
	    if (input.split(" ")[0].equals("#")) {
		modus = input.split(" ")[1];
		//System.out.println("Modus: " + modus);
	    } else {
		line = input.split(", ");
		if (modus.equals("Personer") && line.length == 5){
		    addPerson(line[0], line[1], line[2], line[3], line[4]);
		} else if (modus.equals("Legemidler") && line.length == 8) {
		    addLegemiddel(line[0], line[1], line[2], line[3],
				  line[4], line[5], line[6], line[7]);
		} else if (modus.equals("Legemidler") && line.length == 7) {
		    addLegemiddel(line[0], line[1], line[2], line[3],
				  line[4], line[5], line[6]);
		} else if (modus.equals("Leger") && line.length == 2) {
		    addLege(line[0], line[1]);
		} else if (modus.equals("Resepter") && line.length == 6) {
		    addResept(line[0], line[1], line[2], line[3], line[4],
			      line[5]);
		} else {
		    System.out.print("Dårlig formulert linje: ");
		    for (String s : line){System.out.print(s + " ");}
		    System.out.println(line.length);
		}
	    }
	}
    }

    /** 
	Metoden addPerson 
	legger en ny person til i tabellen over personer
	@param i Personens lokale id/loepenr.
	@param navn 
	@param pNr Personens fodselsnummer.
	@param adresse
	@param postnummer
	@see addPerson
     */
    public void addPerson(String i, String navn, String pNr, String adresse,
			  String postNummer) {
	int lpNr = Integer.parseInt(i);
	Person p = new Person(lpNr, navn,
			      pNr, adresse,
			      postNummer);
	personer.add(lpNr, p);
    }
    public void addPerson(String navn, String pNr, String adresse,
			  String postNummer) {
	Person p = new Person(navn, pNr, adresse,
			      postNummer);
	personer.add(p.loepeNr, p);
    }


    /** 
	Metoden addLegemiddel
	legger et nytt legemiddel til i tabellen over legemidler
	@param nr Legemiddelets nummer
	@param navn 
	@param form
	@param type
	@param pris
	@param mengde
	@param virkestoff
	@param styrke
	@see addLegemiddel
     */
    public void addLegemiddel(String nr,String navn,String form,String
			      type,String pris,String mengde,
			      String virkestoff, String styrke) {
	if (type.equals("a") && form.equals("mikstur") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelMiksturA(navn,
						  Integer.parseInt(pris),
						  Integer.parseInt(styrke),
						  Integer.parseInt(mengde),
						  Integer.parseInt(virkestoff)));
	} else if (type.equals("a") && form.equals("pille") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelPillerA(navn,
						 Integer.parseInt(pris),
						 Integer.parseInt(styrke),
						 Integer.parseInt(mengde),
						 Integer.parseInt(virkestoff)));
	} else if (type.equals("b") && form.equals("mikstur") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelMiksturB(navn,
						  Integer.parseInt(pris),
						  Integer.parseInt(styrke),
						  Integer.parseInt(mengde),
						  Integer.parseInt(virkestoff)));
	} else if (type.equals("b") && form.equals("pille") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelPillerB(navn,
						 Integer.parseInt(pris),
						 Integer.parseInt(styrke),
						 Integer.parseInt(mengde),
						 Integer.parseInt(virkestoff)));
	} else {
	    System.out.println("Ukjent legemiddel 1: " + nr);
	}
    }

    public void addLegemiddel(String nr,String navn,String form,String type,
			      String pris,String mengde,String virkestoff) {
	if (type.equals("c") && form.equals("mikstur") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelMiksturC(navn,
						  Integer.parseInt(pris),
						  Integer.parseInt(mengde),
						  Integer.parseInt(virkestoff)));
	} else if (type.equals("c") && form.equals("pille") ) {
	    legemidler.add(Integer.parseInt(nr),
			   new LegemiddelPillerC(navn,
						 Integer.parseInt(pris),
						 Integer.parseInt(mengde),
						 Integer.parseInt(virkestoff)));
	} else {
	    System.out.println("Ukjent legemiddel 2: " + nr);
	}
    }

    /**
       Metoden addLege
       Legger inn lege i lenekelisten over leger.
       	@param navn Legens navn
	@param nrStr nummer
	@see SortertEnkelListe
     */
    public void addLege(String navn, String nrStr) {
	int nr = Integer.parseInt(nrStr);
	if (nr == 0) {
	    leger.add(new Lege(navn), navn);
	} else {
	    leger.add(new Lege(navn, nr), navn);
	}
    }

    /**
       Metoden addResept
       Legger inn resepter i EnkelReseptListe
       @param nrStr reseptnummer 
       @param farge Reseptklasse
       @param pNrstr personnummeret resepten er knyttet til
       @param legeNavn Navnet til legen som foreskrev resepten.
       @param legemiddelNrStr legemiddelnr.
       @param reit
       @see EnkelReseptListe
     */
    public void addResept(String nrStr, String farge, String pNrStr,
			  String legeNavn, String legemiddelNrStr,
			  String reitStr){
	int nr = Integer.parseInt(nrStr);
	int pNr = Integer.parseInt(pNrStr);
	Person person = personer.get(pNr);
	if (person == null) {
	    System.out.println("Ukjent pasient");
	    return;
	}
	int legemiddelNr = Integer.parseInt(legemiddelNrStr);
	Legemiddel legemiddel = legemidler.get(legemiddelNr);
	if (legemiddel == null) {
	    System.out.println("Ukjent legemiddel");
	    return;
	}
	int reit = Integer.parseInt(reitStr);
	Lege lege = leger.get(legeNavn);
	if (lege == null) {
	    System.out.println("Ukjent lege.");
	    return;
	}

	if (farge.equals("hvit")) {
	    resepter.add(new HvitResept(nr, legemiddel, lege, person, reit, 0));
	} else if (farge.equals("blå")) {
	    resepter.add(new BlaResept(nr, legemiddel, lege, person, reit));
	} else {
	    System.out.println("Ukjent reseptfarge");
	}
    }

    /**
       Metoden print 
       Skriver ut alle: 
           Personer i tabellen av personer.
	   Legemidler i tabellen av legemidler
	   Leger i listen av leger. 
     */
    public String print() {
	String s="# Personer (nr, navn, fnr, adresse, postnr)\n";
	for (Person p : personer){
	    s+= String.format("%d, %s, %s, %s, %s\n",
			      p.loepeNr, p.navn, p.fnummer,
			      p.adresse, p.postnummer);
	}

	s+="# Legemidler (nr, navn, form, type, pris, antall,"+
	    " virkestoff [, styrke])\n";
	for (Legemiddel m : legemidler) {
	    s+=m.getNummer();
	    s+=", ";
	    s+=m.getNavn();
	    s+=", ";
	    if (m instanceof LegemiddelMikstur) {
		s+="mikstur, ";
	    } else if (m instanceof LegemiddelPiller) {
		s+="pille, ";
	    }
	    if (m instanceof LegemiddelA) {
		s+="a, ";
	    } else if (m instanceof LegemiddelB) {
		s+="b, ";
	    } else if (m instanceof LegemiddelC) {
		s+="c, ";
	    }
	    s+=m.getPris();
	    s+=", ";
	    if (m instanceof LegemiddelPiller) {
		s+=((LegemiddelPiller)m).pillerPerEske();
		s+=", ";
		s+=((LegemiddelPiller)m).virkestoffPerPille();
	    } else if (m instanceof LegemiddelMikstur) {
		s+=((LegemiddelMikstur)m).cm3perFlaske();
		s+=", ";
		s+=((LegemiddelMikstur)m).virkestoffPercm3();
	    }
	    if (m instanceof LegemiddelA){
		s+=", ";
		s+=((LegemiddelA)m).getNarkotiskhet();
	    } else if (m instanceof LegemiddelB) {
		s+=", ";
		s+=((LegemiddelB)m).getVanedannendehet();
	    }
	    s+="\n";
	}

	s+="# Leger (navn, avtalenr / 0 hvis ingen avtale)\n";

	for (Lege l : leger ) {
	    s+=l.getNavn();
	    s+=", ";
	    s+=l.avtaleNummer;
	    s+="\n";
	}
	s+=printResept();

	return s;
    }

    /**
       Metoden printResept
       Skriver ut all informasjon om hver enkel resept i 
       resept-tabellen.
       @return formatert streng med reseptinformasjon.
     */
    public String printResept(){
	 String s="# Resepter (nr, hvit/blå, persNummer,"+
	     " legeNavn, legemiddelNummer, reit)\n";
	 for (Resept r : resepter){
	    s+=r.getNummer();
	    s+=", ";
	    if (r instanceof BlaResept) {
		s+="blå";
	    } else if (r instanceof HvitResept) {
		s+="hvit";
	    }
	    s+=", ";
	    s+=r.getPasient().loepeNr;
	    s+=", ";
	    s+=r.getLege().getNavn();
	    s+=", ";
	    s+=r.getLegemiddel().getNummer();
	    s+=", ";
	    s+=r.getReit();
	    s+="\n";
	}
	 return s;
    }

    /**
       Metoden getResept
       Henter ut resepter i eresept-tabellen basert paa id.
       @param id index i tabell
       @return Resept resepten
     */
    public Resept getResept(int id) {return resepter.get(id);}


    /**
       Metoden printNarkotika.
       Metoden skriver ut antallet resepter av vanedannende eller narkotisk
       type foreskrevet personer i Oslo.
       @see Resept
       @see Legemiddel
     */
    public void printNarkotika() {
	int n=0;
	int o=0;
	for (Resept r : resepter) {
	    Legemiddel l = r.getLegemiddel();
	    if (l instanceof LegemiddelA || l instanceof LegemiddelB) {
		n++;
		if (Integer.parseInt(r.getPasient().postnummer) <= 1295){
		    o++;
		}
	    }
	}
	System.out.println("Av " +n+ " resepter på narkotiske legemidler er "
			   + o + " skrevet ut til noen i Oslo");
    }

    /**
       Metoden skriver ut statistikk om resepter tilhoerende en lege.
       Bl.a den samlede mengden virkestoff og om reseptens legemiddel er av 
       pille'- eller miksturtype, samt antall/mengde av legemiddelet.
       @param navn Legens navn
       @see Legemiddel
       @see Resept
    */
    public void printLegeStatistikk(String navn) {
	int totMVirkestoff = 0;
	int totPVirkestoff = 0;
	int mengdePilleform = 0;
	int mengdeFlytende = 0;

	for (Resept r : resepter) {
	    if (r.getLege().getNavn().equals(navn)) {
		Legemiddel lm = r.getLegemiddel();
		if (lm instanceof LegemiddelMikstur) {
		    System.out.printf("%s (mikstur)\n", lm.getNavn());
		    if (lm instanceof LegemiddelMiksturA) {
			totMVirkestoff +=
			    ((LegemiddelMiksturA)lm).virkestoffPercm3();
			mengdeFlytende +=
			    ((LegemiddelMiksturA)lm).cm3perFlaske();
		    }
		    if (lm instanceof LegemiddelMiksturB) {
			totMVirkestoff +=
			    ((LegemiddelMiksturB)lm).virkestoffPercm3();
			mengdeFlytende +=
			    ((LegemiddelMiksturB)lm).cm3perFlaske();
		    }
		    if (lm instanceof LegemiddelMiksturC) {
			totMVirkestoff +=
			    ((LegemiddelMiksturC)lm).virkestoffPercm3();
			mengdeFlytende +=
			    ((LegemiddelMiksturC)lm).cm3perFlaske();
		    }
		} else if (lm instanceof LegemiddelPiller) {
		    if (lm instanceof LegemiddelPillerA) {
			totPVirkestoff +=
			    ((LegemiddelPillerA)lm).virkestoffPerPille();
			mengdePilleform +=
			    ((LegemiddelPillerA)lm).pillerPerEske();
		    }
		    if (lm instanceof LegemiddelPillerB) {
			totPVirkestoff +=
			    ((LegemiddelPillerB)lm).virkestoffPerPille();
			mengdePilleform +=
			    ((LegemiddelPillerB)lm).pillerPerEske();
		    }
		    if (lm instanceof LegemiddelPillerC) {
			totPVirkestoff +=
			    ((LegemiddelPillerC)lm).virkestoffPerPille();
			mengdePilleform +=
			    ((LegemiddelPillerC)lm).pillerPerEske();
		    }
		}
	    }
	}
	System.out.println("informasjon om "+navn+"s utskrevne resepter:");
	System.out.println("Mengde virkestoff (mikstur): " +totMVirkestoff);
	System.out.println("Antall cm3 Mikstur: "+mengdeFlytende);
	System.out.println("Mengde virkestoff (Pille): " +totPVirkestoff);
	System.out.println("Antall piller: "+mengdePilleform);
	System.out.println("Samlet Mengde Virkestoff: "
			   +(totMVirkestoff+totPVirkestoff));
    }

    /**
       Metoden printMisbruk.
       Angir alle leger som har skrevet ut en eller flere resepter av type A
       legemiddel til terminal. 

       Etter dette blir personer som har gyldige resepter paa legemidler av
       typen A skrevet ut og antallet de besitter.
       
       @ee LegemiddelA
       @see Resept
       @see Lege
       @see Person
     */
    public void printMisbruk(){
	int antallNarko = 0;
	System.out.println("\nLeger som har skrevet ut resept "+
			   "pa minst ett narkotisk legemiddel (Type A): ");
	for (Lege l : leger) {
	    Boolean treffLege = false;
	    for (Resept r : resepter) {
		Legemiddel lm = r.getLegemiddel();
		if (lm instanceof LegemiddelA &&
		    r.getLege().getNavn().equals(l.getNavn())) {
			treffLege = true;
			antallNarko++;
		    }
	    }
	    if (treffLege) {
		System.out.print(l.getNavn());
		System.out.printf(": Har skrevet ut %d resept%s av typen A\n",
				  antallNarko, (antallNarko>1)?"er":"");
		antallNarko = 0;

	    }
	}
	System.out.println("\nPersoner som besitter resepter av typen A:");

	int antallA = 0;
	for (Person p : personer) {
	    Boolean persTreff = false;
	 for (Resept r : resepter) {
		Legemiddel lm = r.getLegemiddel();
		if (lm instanceof LegemiddelA  &&
		    r.getPasient().navn.equals(p.navn) && r.getReit() > 0) {
		    persTreff = true;
		    antallA++;
		}
	 }
	    if (persTreff) {
		System.out.printf("%s innehar %d Gyldig%s resept%s\n",
				  p.navn, antallA, antallA>1?"e":"",
				  antallA>1?"er":"");
		antallA = 0;
	    }
	}
    }


    /**
       Metoden printResept.
       For en git person skriver ut alle den bla resepter, yngste 
       foerst.
       @param nr Det unike nummeret til personen.
     */
    public void printResept(long nr){
	for (Resept r : resepter){
	    if (r instanceof BlaResept) {
		Person p = r.getPasient();
		if (p.fnummer.equals(nr) || p.loepeNr == nr) {
		    int reit = r.getReit();
		    String navn = r.getLegemiddel().getNavn();
		    System.out.println(navn + ": " + reit);
		}
	    }
	}
    }
}
