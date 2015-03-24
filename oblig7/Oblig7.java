import java.util.*;

class Oblig7 {
    public static void main(String[] args) {
        Eresept eresept = new Eresept();
        eresept.load("data.txt");
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
	    case "0":
		System.exit(0);
		break;
            case "1":
                help();
                break;
            case "2":
            //"2) skriv til fil og avslutt",
                eresept.save("data.txt");
                System.exit(0);
                break;
            case "3":
                skrivUtPersoner();
                break;
            case "4":
                skrivUtLeger();
                break;
            case "5":
            //"5) Skrive ut alle personer, alle leger (sortert på navn), aller legemidler og alle resepter.",
                System.out.println(eresept.print());
                break;
            case "6":
                printResept();
                break;
            case "7":
                addLegemiddel();
                break;
            case "8":
                addLege();
                break;
            case "9":
                addPerson();
                break;
            case "10":
                addResept();
                break;
            case "11":
                hentResept();
                break;
            case "12":
                eresept.printNarkotika();
                break;
            case "13":
		printLegeStatistikk();
                break;
            case "14":
		eresept.printMisbruk();
                break;
            default:
                break;
            }
            System.out.print("oblig7# ");
        }
    }
    public void help(){
        String[] h = {
	    "0) avslutt",
            "1) hjelp",
            "2) skriv til fil og avslutt",
            "3) print personer",
            "4) print leger",
            "5) Skrive ut alle personer, alle leger (sortert på navn), aller legemidler og alle resepter",
            "6) print alle blå resepter på en pasient",
            "7) opprett nytt legemiddel",
            "8) opprett ny lege",
            "9) opprett ny person",
            "10) opprett ny resept",
            "11) Hent resept",
            "12) print narkostatistikk for oslo",
            "13) skriv ut statistikk om lege",
            "14) skriv ut statistikk om misbruk"
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
        String nr = Integer.toString(Legemiddel.get_last_nummer()); 
        if (type.equals("a") || type.equals("b")) {
            System.out.print("styrke: ");
            String styrke = sc.nextLine();
            eresept.addLegemiddel(nr, navn, form, type, pris,mengde,virkestoff,styrke);
        } else {
            eresept.addLegemiddel(nr, navn, form, type, pris,mengde,virkestoff);
        }
    }
    public void addLege(){
        System.out.print("Navn: ");
        String navn = sc.nextLine();
        System.out.print("Nummer (0 for ingen): ");
        String nr = sc.nextLine();
        eresept.addLege(navn,nr);
    }
    public void addPerson(){
        System.out.print("Navn: ");
        String navn = sc.nextLine();
        System.out.print("Personnummer: ");
        String pnr = sc.nextLine();
        System.out.print("Adresse: ");
        String adr = sc.nextLine();
        System.out.print("Postnummer: ");
        String postnr = sc.nextLine();
        eresept.addPerson(navn, pnr, adr, postnr);
    }
    public void addResept() {
        System.out.print("Farge (blå/hvit): ");
        String farge = sc.nextLine();
        System.out.print("Pasientens personnummer: ");
        String pnr = sc.nextLine();
        System.out.print("Legens navn: ");
        String lege = sc.nextLine();
        System.out.print("Legemiddelnummer: ");
        String legemiddelnr = sc.nextLine();
        System.out.print("Reit: ");
        String reit = sc.nextLine();
        String nr = Integer.toString(Resept.get_sist_nummer());
        eresept.addResept(nr, farge, pnr, lege, legemiddelnr, reit);
    }
    public void printResept(){
        System.out.print("Personnummer eller nummer på pasient: ");
        String nr = sc.nextLine();
        eresept.printResept(Long.parseLong(nr));
    }
    public void skrivUtPersoner() {
        System.out.println("Personer i registeret:");
	System.out.printf("%-30s %s\n", "[Navn:]","[Personnummer:]");
        for (Person p : eresept.personer)
            System.out.printf("%-30s %s\n", p.navn,
			       p.getPersonNummer());
    }
    
    public void skrivUtLeger() {
        System.out.println("Leger i registeret: ");
	System.out.printf("%-10s %s\n", "[Navn]", "[Avtalenr.:]");
        for (Lege l : eresept.leger)
            System.out.printf("%-10s %d\n", l.getNavn(), l.getAvtalenr());
    }

    public void printLegeStatistikk() {
        System.out.print("Navn paa lege: ");
        String navn = sc.nextLine();
        eresept.printLegeStatistikk(navn);
    }

}

