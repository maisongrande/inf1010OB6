import java.util.NoSuchElementException;
class TestSortertEnkelListe
{
    public static void main(String[] args) {
	SortertEnkelListe<Lege> sel = new SortertEnkelListe<Lege>();
	String[] dr = {"Dr. Dre", "Dr. Proktor", "Dr. Alban", "Dr. House"};
	    
	Lege l1 = new Lege(dr[0]);
	Lege l2 = new Lege(dr[1]);
      	Lege l3 = new Lege(dr[2]);
	Lege l4 = new Lege(dr[3]);

	System.out.println("* Tester add(Lege) *");
	if (sel.add(l1,"1") && sel.add(l2,"2") && sel.add(l3,"3")
	    && sel.add(l4,"4"))
	    System.out.println("Insertion -> OK");
	else
	    System.out.println("Insertion -> FAILED");

	boolean suksess = true;
        boolean suksess2 = true;
	String s1 = "";
	String s2 = "";
	String t = "";	

	System.out.printf("\nTester get() paa alle insatte + 1\n");
	for (int i=1; i < dr.length + 2; i++) {
	    try {
		s1 = sel.get(Integer.toString(i)).getNavn();
		s2 = dr[i-1];
		if (s1 == s2)
		    suksess2 = true;
		else
		    suksess2 = false;
	    } catch (NoSuchElementException e) {suksess = false;}

	    if (i > 4)
		test("Test av Lege som ikke finnes m/get(). Skal feile",
		     suksess);
	    else {
		test("Test av Lege som finnes m/get()", suksess);
		t = String.format("%s == %s", s1, s2);		
		test(t, suksess2);
	    }
	}

	System.out.printf("\nTester iterator over alle insatte\n");
	for(Lege lege: sel)
	    System.out.println(lege.getNavn());
	
    }

    static void test(String s, Boolean value) {
	System.out.printf("%s : %s\n", s, value?"OK":"FAIL");
    }
}

