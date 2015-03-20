import java.util.*;
import java.io.*;
class Eresept {
    Tabell personer = new Tabell(100000); // FIXME
    
    public void load(String filnavn) {
        Scanner fil;
        try {
            fil = new Scanner(new File(filnavn));
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
        String[] line;
        String modus;
        while (fil.hasNextLine()){
            line = fil.nextLine().split(" |, ");
            if (line[0] == "#") {
                modus = line[1];
            } else {
                if (modus == "Personer" && line.length == 5){
                    addPerson(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), line[3], Integer.parseInt(line[4]));
                } else if (modus == "Legemidler" && line.length == 8) {
                } else if (modus == "Lege" && line.length == 2) {
                } else if (modus == "Resepter" && line.length == 6) {
                } else {
                    System.out.println("Dårlig formulert linje: " + line);
                }
            }
        }
    }

    public void addPerson(int i, String navn, int pNr, String adresse, int postNummer){
        
    }
    //void save(){}
}
