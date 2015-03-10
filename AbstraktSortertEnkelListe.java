public interface AbstraktSortertEnkelListe<T implements Comperable & Lik>  {

    boolean add(T obj);
    T get(String s);
    Iterator<T> Iterator();

    }
