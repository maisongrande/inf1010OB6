class TestTabell {
    /* Helt basic test av add  og iterator-metoden for Tabell-klassen. */
    public static void main(String[] args) {

	if (args.length == 0) {
	    System.out.println("Usage: java TestTabell [arg1 ... argN]");
	    System.exit(0);
	}
	
	int i = 0;
	Tabell<String> t1 = new Tabell<String>(args.length); 


	System.out.println("Tester add() og iterator\n");	
	System.out.println("Legger i array med add():");

	for (String s: args) {
	    System.out.printf("%s -> %s\n",
			      s,
			      t1.add(i++, s)==true?"OK":"FAIL");
	}	

	System.out.println("Loper gjennom Tabell<String> array m/iterator");
	i = 0;
	for (String s: t1)
	    System.out.printf("array[%d] = %s\n", i++, s);

	System.out.println("Prover aa legge samme elementer inn i Array");

	i = 0;
	for (String s: args) {
	    System.out.printf("%s -> %s\n",
			      s,
			      t1.add(i++, s)==true?"OK":"FAIL");
	}	

	System.out.println("\nTester get:\n");

	for (i = 0; i < args.length; i++)
	    System.out.printf("get(%d) = %s\n", i, t1.get(i));
    }

}
