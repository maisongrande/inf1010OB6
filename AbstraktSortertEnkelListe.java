import java.util.*;
public interface AbstraktSortertEnkelListe<T extends Comparable & Lik> {

  boolean add(T obj, String s);
  T get(String s);
  Iterator<T> iterator();

}
