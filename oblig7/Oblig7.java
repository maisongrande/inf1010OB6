import java.util.*;

class Oblig7 {
    public static void main(String[] args) {
        Eresept eresept = new Eresept();
        eresept.load("data.txt");
        System.out.println(eresept.print());
        EreseptMenu menu = new EreseptMenu(eresept);
        menu.commandLoop();
    }
}

class EreseptMenu{
    Eresept eresept;
    Scanner sc = new Scanner(System.in);
    public EreseptMenu(Eresept eresept){
        this.eresept = eresept;
    }

    public void commandLoop(){
        help();
        System.out.print("oblig# ");
        while(sc.hasNext()) {
            switch (sc.next()){
            case "1":
                help();
                break;
            case "11":
                hentResept();
                break;
            default:
                help();
                break;
            }
            System.out.print("oblig# ");
        }
    }
    public void help(){
        String[] h = {
            "1) hjelp",
            "2) save and quit",
            "3) print persons",
            "4) print doctors",
            "5) print dr)ugs",
            "6) print pr(e)scriptions",
            "7) new drug",
            "8) new doctor",
            "9) new person",
            "10) new prescriptions",
            "11) Hent resept",
            "12) print statistics",
        };
        for (String l : h) {
            System.out.println(l);
        }
    }
    public void hentResept(){
        System.out.println("Velg resept: ");
        System.out.print(eresept.printResept());
        System.out.print("> ");
        int valg = Integer.parseInt(sc.next());
        Resept resept = eresept.getResept(valg);
        if(resept.hentResept()) {
            System.out.println("Medisin til deg");
        } else {
            System.out.println("Ikke mer medisin til deg. :(");
        }
    }
}
