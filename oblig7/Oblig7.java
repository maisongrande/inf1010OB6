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
            switch (sc.nextLine()){
            case "1":
            //"1) hjelp",
                help();
                break;
            case "2":
            //"2) skriv til fil og avslutt",
                break;
            case "3":
            //"3) print personer",
                skrivUtPersoner();
                break;
            case "4":
            //"4) print leger",
                skrivUtLeger();
                break;
            case "5":
            //"5) print legemidler",
                break;
            case "6":
            //"6) print resepter",
                break;
            case "7":
            //"7) opprett nytt legemiddel",
                addLegemiddel();
                break;
            case "8":
            // "8) opprett ny lege",
                break;
            case "9":
            // "9) opprett ny person",
                break;
            case "10":
            // "10) opprett ny resept",
                break;
            case "11":
            // "11) Hent resept",
                hentResept();
                break;
            case "12":
            // "12) print statistikk",
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
            "2) skriv til fil og avslutt",
            "3) print personer",
            "4) print leger",
            "5) print legemidler",
            "6) print resepter",
            "7) opprett nytt legemiddel",
            "8) opprett ny lege",
            "9) opprett ny person",
            "10) opprett ny resept",
            "11) Hent resept",
            "12) print statistikk",
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

    public void addLegemiddel(){
        String nr = Integer.toString(Legemiddel.get_last_nummer()); 
        System.out.print("Navn på legemiddel: ");
        String navn = sc.nextLine();
        System.out.print("mikstur eller pille? ");
        String form = sc.nextLine();
        System.out.print("Type? (a,b,c): ");
        String type = sc.nextLine();
        System.out.print("pris: ");
        String pris = sc.nextLine();
        System.out.print("mengde: ");
        String mengde = sc.nextLine();
        System.out.print("virkestoff: ");
        String virkestoff = sc.nextLine();
        if (type.equals("a") || type.equals("b")) {
            System.out.print("styrke: ");
            String styrke = sc.nextLine();
            eresept.addLegemiddel(nr, navn, form, type, pris,mengde,virkestoff,styrke);
        } else {
            eresept.addLegemiddel(nr, navn, form, type, pris,mengde,virkestoff);
        }
    }

    public void skrivUtPersoner() {
        System.out.println("Personer i registeret: ");
        for (Person p : eresept.personer)
            System.out.printf("%s\n", p.navn);
    }
    
    public void skrivUtLeger() {
        System.out.println("Leger i registeret: ");
        for (Lege l : eresept.leger)
            System.out.printf("%s\n", l.getNavn());
        
    }
}
