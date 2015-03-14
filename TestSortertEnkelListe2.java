import java.util.*;
class TestSortertEnkelListe2 {
    public static void main(String[] args) {
        SortertEnkelListe<Lege> sel = new SortertEnkelListe<Lege>();

        Lege l = new Lege("Doktor Dyregod");
        sel.add(l, "fjas");
        test("Legge til og hente lege", (sel.get("fjas").samme(l)));

        Boolean test = false;
        try {
            sel.get("tut");
        } catch (Exception e) {
            test = true;
        }
        test("Hente noe som ikke finnes kaster exception", test);


        Lege[] leger = {new Lege("Dyregod"), new Lege("Alban"), new Lege("House"), new Lege("Dre")};

        sel = new SortertEnkelListe<Lege>();
        for (Lege lege : leger ){
            sel.add(lege, "");
        }

        System.out.println("Sjekke sortering: ");
        Arrays.sort(leger);
        int n=0;
        for (Lege lege : sel) {
            test(lege + " (" + leger[n] + ")", (lege == leger[n++]));
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

