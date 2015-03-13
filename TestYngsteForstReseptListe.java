import java.util.NoSuchElementException;
public class TestYngsteForstReseptListe {
    public static void main(String[] args){

        YngsteForstReseptListe erl = new YngsteForstReseptListe();

        Legemiddel legemiddel = new LegemiddelMiksturA("Ritalin", 66, 1,2,3);
        Lege lege = new Lege("Doktor Dyregod");
        Person person = new Person("Bottulf", 123);

        erl.add(new BlaResept(legemiddel, lege, person, 1));
        erl.add(new BlaResept(legemiddel, lege, person, 2));
        erl.add(new BlaResept(legemiddel, lege, person, 3));
        Resept r = new BlaResept(legemiddel, lege, person, 1);

        test("Løpenummer på resept funker", (r.nummer == 4));

        r = new BlaResept(legemiddel, lege, person, 1);
        erl.add(r);
        test("Legge til og hente ut den samme resepten", (erl.get(r.nummer).nummer == r.nummer));

        Boolean suksess = false;
        try {
            erl.get(666);
        } catch (NoSuchElementException e) {
            suksess = true;
        }
        test("Resept som ikke finnes kaster exception", suksess);


        erl = new YngsteForstReseptListe();
        for (int i=1;i<11;i++) {
            erl.add(new BlaResept(legemiddel, lege, person, 1));
        }
        Resept siste = new BlaResept(legemiddel, lege, person, 1);
        erl.add(siste);
        int nummer=siste.nummer;
        for (Resept resept : erl){
            test("Resept " + nummer + " kommer på rett plass under iterering", (resept.nummer == nummer--));
        }

    }
    static void test(String s, Boolean value){
        System.out.print(s + ": ");
        if (value){
            System.out.println("OK");
            return;
        }
        System.out.println("FAIL");
    }
}
