import java.util.*;
/**
 * Interface AbstraktSortertEnkelListe inneholder metode-signatur
 * for metodene som inngaar i klasser som implementerer
 * AbstraktSortertEnkelListe.
 */
public interface AbstraktSortertEnkelListe<T extends Comparable & Lik> {

  boolean add(T obj, String s);
  T get(String s);
  Iterator<T> iterator();

}
