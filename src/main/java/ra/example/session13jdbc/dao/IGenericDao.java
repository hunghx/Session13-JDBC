package ra.example.session13jdbc.dao;

import java.util.List;

public interface IGenericDao <T,E>{
    List<T> getAll();
    T getById(E id);
    void add(T t);
    void update(T t);
    void deleteById(E id);
}
