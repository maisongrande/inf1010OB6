import java.util.*;
import java.io.*;
class Eresept {
    Tabell<Person> personer = new Tabell<Person>(100000); 
    EnkelReseptListe resepter = new EnkelReseptListe();
    SortertEnkelListe<Lege> leger = new SortertEnkelListe<Lege>();
    Tabell<Legemiddel> legemidler = new Tabell<Legemiddel>(100000);

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
                System.out.println("Modus: " + modus);
            } else {
                line = input.split(", ");
                if (modus.equals("Personer") && line.length == 5){
                    addPerson(line[0], line[1], line[2], line[3], line[4]);
                } else if (modus.equals("Legemidler") && line.length == 8) {
                    addLegemiddel(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                } else if (modus.equals("Legemidler") && line.length == 7) {
                    addLegemiddel(line[0], line[1], line[2], line[3], line[4], line[5], line[6]);
                } else if (modus.equals("Leger") && line.length == 2) {
                    addLege(line[0], line[1]);
                } else if (modus.equals("Resepter") && line.length == 6) {
                    addResept(line[0], line[1], line[2], line[3], line[4], line[5]);
                } else {
                    System.out.print("Dårlig formulert linje: ");
                    for (String s : line){System.out.print(s + " ");}
                    System.out.println(line.length);
                }
            }
        }
    }

    public void addPerson(String i, String navn, String pNr, String adresse,
                          String postNummer) {
        int lpNr = Integer.parseInt(i);
        Person p = new Person(lpNr, navn,
                              Long.parseLong(pNr), adresse,
                              postNummer);
        personer.add(lpNr, p);
    }
    public void addPerson(String navn, String pNr, String adresse, String
                          postNummer) {
        Person p = new Person(navn, Long.parseLong(pNr), adresse,
                              postNummer);
        personer.add(p.loepeNr, p);
    }

    public void addLegemiddel(String nr,String navn,String form,String
                              type,String pris,String mengde,String virkestoff, String styrke) {
        if (type.equals("a") && form.equals("mikstur") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturA(navn,
                                                                        Integer.parseInt(pris),
                                                                        Integer.parseInt(styrke),
                                                                        Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else if (type.equals("a") && form.equals("pille") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelPillerA(navn,
                                                                       Integer.parseInt(pris),
                                                                       Integer.parseInt(styrke),
                                                                       Integer.parseInt(mengde),
                                                                       Integer.parseInt(virkestoff)));
        } else if (type.equals("b") && form.equals("mikstur") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturB(navn,
                                                                        Integer.parseInt(pris),
                                                                        Integer.parseInt(styrke),
                                                                        Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else if (type.equals("b") && form.equals("pille") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturB(navn,
                                                                        Integer.parseInt(pris),
                                                                        Integer.parseInt(styrke),
                                                                        Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else {
            System.out.println("Ukjent legemiddel: " + nr);
        }
    }

    public void addLegemiddel(String nr,String navn,String form,String type,String pris,String mengde,String virkestoff) {
        if (type.equals("c") && form.equals("mikstur") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturC(navn,
                                                                        Integer.parseInt(pris),
                                                                        Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else if (type.equals( "c") && form.equals("pille") ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelPillerC(navn,
                                                                       Integer.parseInt(pris),
                                                                       Integer.parseInt(mengde),
                                                                       Integer.parseInt(virkestoff)));
        } else {
            System.out.println("Ukjent legemiddel: " + nr);
        }
    }
    
    public void addLege(String navn, String nrStr) {
        int nr = Integer.parseInt(nrStr);
        if (nr == 0) {
            leger.add(new Lege(navn), navn);
        } else {
            leger.add(new Lege(navn, nr), navn);
        }
    }

    public void addResept(String nrStr, String farge, String pNrStr, String legeNavn, String legemiddelNrStr, String reitStr){
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

    public String print() {
        String s="# Personer (nr, navn, fnr, adresse, postnr)\n";
        for (Person p : personer){
            s+= String.format("%d, %s, %d, %s, %s\n", p.loepeNr, p.navn, p.fnummer, p.adresse, p.postnummer);
        }

        s+="# Legemidler (nr, navn, form, type, pris, antall, virkestoff [, styrke])";
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
        return s;
    }
    //void save(){}
}
  
