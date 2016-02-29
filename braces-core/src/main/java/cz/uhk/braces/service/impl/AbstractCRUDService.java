package cz.uhk.braces.service.impl;

import cz.uhk.braces.service.CRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rezy
 * Date: 27.10.13
 */
public abstract class AbstractCRUDService<T, R extends JpaRepository<T, Long>> implements CRUDService<T> {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractCRUDService.class);

	private final R repository;

	protected AbstractCRUDService(R repository) {
		this.repository = repository;
	}

	@Override
	public T getByID(Long id) {
		LOG.info("Try to find entity with ID {}", id);
		return repository.getOne(id);
	}

	@Override
	public void update(T type) {
		LOG.info("Try to create or update entity {}", type);
		repository.save(type);
	}

	@Override
	public void delete(Long id) {
		LOG.info("Entity with ID {} will be removed", id);
		repository.delete(id);
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}
}
