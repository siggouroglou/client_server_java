package gr.unipi.mainpackage.server.service.fileManager;

import java.util.List;

/**
 * This interface defines a type for classes that are serving a database front end.
 * @author siggouroglou
 * @param <T> The types of data in the database.
 */
public interface DbFileManager<T> {

    public T create(T t);

    public List<T> readAll(T t);

    public T read(T t);

    public T update(T t);

    public T delete(T t);
}
