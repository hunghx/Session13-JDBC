package ra.example.session13jdbc.service;

import java.util.List;

public interface IGenericService<T,E> {
    List<T> getAll();
    T getById(E id);
    void add(T t);
    void update(T t);
    void deleteById(E id);
}
