import java.util.*;

public interface AbstraktTabell<T>  {

    boolean add(int index, T obj);
    T get(int index);
    Iterator<T> iterator();
    
}
