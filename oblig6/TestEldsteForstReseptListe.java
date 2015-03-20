import java.util.NoSuchElementException;
public class TestEldsteForstReseptListe {
    public static void main(String[] args){

        EldsteForstReseptListe erl = new EldsteForstReseptListe();

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
        test("Legge og hente ut den samme resepten", (erl.get(r.nummer).nummer == r.nummer));

        Boolean suksess = false;
        try {
            erl.get(666);
        } catch (NoSuchElementException e) {
            suksess = true;
        }
        test("Resept som ikke finnes kaster exception", suksess);


        erl = new EldsteForstReseptListe();
        Resept forste = new BlaResept(legemiddel, lege, person, 1);
        erl.add(forste);
        for (int i=1;i<11;i++) {
            erl.add(new BlaResept(legemiddel, lege, person, 1));
        }
        int nummer=forste.nummer;
        for (Resept resept : erl){
            test("Resept " + nummer + " kommer på rett plass", (resept.nummer == nummer++));
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
