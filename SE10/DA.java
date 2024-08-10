package SE10;

import java.util.List;

public interface DA<T,I> {
    void save();
    void edit();
    void remove();
    List<T> findAll();
    T findByid(I id);

}
