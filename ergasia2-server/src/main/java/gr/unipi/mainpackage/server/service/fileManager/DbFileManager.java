package gr.unipi.mainpackage.server.service.fileManager;

import java.util.List;

/**
 *
 * @author siggouroglou
 */
public interface DbFileManager<T> {

    public T create(T t);

    public List<T> readAll(T t);

    public T read(T t);

    public T update(T t);

    public T delete(T t);
}
