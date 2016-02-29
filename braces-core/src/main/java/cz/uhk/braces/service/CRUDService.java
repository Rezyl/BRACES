package cz.uhk.braces.service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 9.2.15
 */
public interface CRUDService<T> {

	T getByID(Long id);

	void update(T type);

	void delete(Long id);

	List<T> getAll();

}
