package dao;

import java.util.List;

public interface dao <K, T> {

    T addUser(T entity);

    List<T> getUsers();

    boolean deleteUser(K id);

}
