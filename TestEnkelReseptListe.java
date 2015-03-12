public class TestEnkelReseptListe {
    public void main(String[] args){

        // EnkelReseptListe
        // add
        // get
        // Exception
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
    void test(String s, Boolean value, Boolean expect){
        System.out.print(s + ": ");
        if (value == expect){
            System.out.println("OK");
            return;
        }
        System.out.println("FAIL")
    }
}
