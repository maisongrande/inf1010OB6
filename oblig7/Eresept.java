import java.util.*;
import java.io.*;
class Eresept {
    Tabell personer = new Tabell(100000); // FIXME
    EnkelReseptListe resepter = new EnkelReseptListe();
    SortertEnkelListe leger = new SortertEnkelListe();
    Tabell legemidler = new Tabell(100000);

    public void load(String filnavn) {
        Scanner fil;
        try {
            fil = new Scanner(new File(filnavn));
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
        String[] line;
        String modus = "tut";
        while (fil.hasNextLine()){
            line = fil.nextLine().split(" |, ");
            if (line[0] == "#") {
                modus = line[1];
            } else {
                if (modus == "Personer" && line.length == 5){
                    addPerson(line[0], line[1], line[2], line[3], line[4]);
                } else if (modus == "Legemidler" && line.length == 8) {
                    addLegemiddel(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                } else if (modus == "Legemidler" && line.length == 7) {
                    addLegemiddel(line[0], line[1], line[2], line[3], line[4], line[5], line[6]);
                } else if (modus == "Lege" && line.length == 2) {
                    
                } else if (modus == "Resepter" && line.length == 6) {
                } else {
                    System.out.println("Dårlig formulert linje: " + line[0]);
                }
            }
        }
    }

    public void addPerson(String i, String navn, String pNr, String adresse,
                          String postNummer) {
        int lpNr = Integer.parseInt(i);
        Person p = new Person(lpNr, navn,
                              Integer.parseInt(pNr), adresse,
                              Integer.parseInt(postNummer));
        personer.add(lpNr, p);
    }
    public void addPerson(String navn, String pNr, String adresse, String
                          postNummer) {
        Person p = new Person(navn, Integer.parseInt(pNr), adresse,
                              Integer.parseInt(postNummer));
        personer.add(p.loepeNr, p);
    }

    public void addLegemiddel(String nr,String navn,String form,String
                              type,String pris,String mengde,String virkestoff, String styrke) {
        if (type == "a" && form == "mikstur" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturA(navn,
                                                                        Integer.parseInt(pris), Integer.parseInt(styrke), Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else if (type == "a" && form == "pille" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelPillerA(navn,
                                                                       Integer.parseInt(pris), Integer.parseInt(styrke),
                                                                       Integer.parseInt(mengde), Integer.parseInt(virkestoff)));
        } else if (type == "b" && form == "mikstur" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturB(navn,
                                                                        Integer.parseInt(pris), Integer.parseInt(styrke),
                                                                        Integer.parseInt(mengde), Integer.parseInt(virkestoff)));
        } else if (type == "b" && form == "pille" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturB(navn,
                                                                        Integer.parseInt(pris), Integer.parseInt(styrke),
                                                                        Integer.parseInt(mengde), Integer.parseInt(virkestoff)));
        } else {
            System.out.println("Ukjent legemiddel: " + nr);
        }
    }

    public void addLegemiddel(String nr,String navn,String form,String type,String pris,String mengde,String virkestoff) {
        if (type == "c" && form == "mikstur" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelMiksturC(navn,
                                                                        Integer.parseInt(pris), Integer.parseInt(mengde),
                                                                        Integer.parseInt(virkestoff)));
        } else if (type == "c" && form == "pille" ) {
            legemidler.add(Integer.parseInt(nr), new LegemiddelPillerC(navn,
                                                                       Integer.parseInt(pris), Integer.parseInt(mengde),
                                                                       Integer.parseInt(virkestoff)));
        } else {
            System.out.println("Ukjent legemiddel: " + nr);
        }
    }

    //void save(){}
}

