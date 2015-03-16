import java.util.*;
/**
 * Interface AbstraktTabell inneholder metode-sign
 * for metodene som inngaar i klasser som implementerer
 * AbstraktTabell.
 */
public interface AbstraktTabell<T>  {
    /**
     * Metoden add legger et nytt element inn paa plassen
     * spesifisert i kallet.
     * @param index Plassen i array objektet skal plassseres.
     * @param obj Objektet som skal plasseres.
     * @return true/false Avhengig av utfall
     */
    boolean add(int index, T obj);

    /**
     * Metoden get returnerer objektet paa plassen spesifisert
     * i metode-kallet.
     * @param index Indeksen hvor elementet som skal returneres er.
     * @return objektet selv.
     */
    T get(int index);

    /**
     * Metoden iterator returnerer et nytt Iterator-objekt.
     * @return Iterator-objektet.
     * @see Iterator-interface.
     */
    Iterator<T> iterator();
}
