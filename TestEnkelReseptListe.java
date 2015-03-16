import java.util.NoSuchElementException;
public class TestEnkelReseptListe {
    public static void main(String[] args){

        EnkelReseptListe erl = new EnkelReseptListe();

        Legemiddel legemiddel = new LegemiddelMiksturA("Ritalin", 66, 1,2,3);
        Lege lege = new Lege("Doktor Dyregod");
        Person person = new Person("Bottulf", 123);

        erl.add(new BlaResept(legemiddel, lege, person, 1));
        erl.add(new BlaResept(legemiddel, lege, person, 2));
        erl.add(new BlaResept(legemiddel, lege, person, 3));
        Resept r = new BlaResept(legemiddel, lege, person, 1);

        test("Løpenummer på resept funker", (r.nummer == 4), true);

        r = new BlaResept(legemiddel, lege, person, 1);
        erl.add(r);
        test("Legge og hente ut den samme resepten", (erl.get(r.nummer).nummer == r.nummer), true);

        Boolean suksess = false;
        try {
            erl.get(666);
        } catch (NoSuchElementException e) {
            suksess = true;
        }
        test("Resept som ikke finnes kaster exception", suksess, true);


        // EldsteForstReseptListe
        // teller opppover
        // YngsteForstReseptListe
        //teller nedover

        // Tabell
        // add
        // // add utenfor
        // get
        // get utenfor
        // get ikkeeksisterende
        // itererere

        // SortertEnkelListe
        // add
        // add noe som ikke er comparable
        // get
        // get noe som ikke finnes
        // itererer
        // sjekk rekkefølge
    }
    static void test(String s, Boolean value, Boolean expect){
        System.out.print(s + ": ");
        if (value == expect){
            System.out.println("OK");
            return;
        }
        System.out.println("FAIL");
    }
}
