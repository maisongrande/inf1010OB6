class TestSortertEnkelListe
{
    public static void main(String[] args) {
	SortertEnkelListe<Leger> sel = new SortertEnkelListe<Leger>();

    }

}
/*  Faar denne feilmeldingen og forstaar ikke helt hvorfor.... */



/*

./TestSortertEnkelListe.java:4: error: type argument Leger is not within bounds of type-variable T
	SortertEnkelListe<Leger> sel = new SortertEnkelListe<Leger>();
	                  ^
  where T is a type-variable:
    T extends Comparable,Lik declared in class SortertEnkelListe
./TestSortertEnkelListe.java:4: error: type argument Leger is not within bounds of type-variable T
	SortertEnkelListe<Leger> sel = new SortertEnkelListe<Leger>();
	                                                     ^
  where T is a type-variable:
    T extends Comparable,Lik declared in class SortertEnkelListe
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
2 errors

*/
