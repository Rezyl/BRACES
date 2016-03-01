package usrm.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: rezy
 * Date: 27.10.13
 */
public abstract class AbstractCRUDService<T> {

	protected abstract JpaRepository<T, Long> getRepositoryInstance();

	public T getByID(Long id) {
		return getRepositoryInstance().findOne(id);
	}

	public void save(T type) {
		getRepositoryInstance().save(type);
	}

	public void edit(T type) {
		getRepositoryInstance().save(type);
	}

	public void delete(Long id) {
		getRepositoryInstance().delete(id);
	}

	public Set<T> getAll() {
		return new HashSet<>(getRepositoryInstance().findAll());
	}

	public void deleteAll() {
		getRepositoryInstance().deleteAll();
	}
}
