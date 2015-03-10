public interface AbstraktSortertEnkelListe<T implements Comperable & Lik>  {

    boolean add(T obj, String s);
    T get(String s);
    Iterator<T> Iterator();

    }
