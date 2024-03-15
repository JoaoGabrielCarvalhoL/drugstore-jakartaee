package br.com.joaogabriel.drugstore.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.drugstore.dao.SimpleCrudDao;
import br.com.joaogabriel.drugstore.dao.enumerations.Ordering;
import br.com.joaogabriel.drugstore.exception.SimpleGenericPersistenceException;
import br.com.joaogabriel.drugstore.util.PersistenceUnitConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public abstract class SimpleGenericDaoImpl<T, ID> implements SimpleCrudDao<T, ID> {

	private EntityManager entityManager = PersistenceUnitConfig.getInstance().getEntityManager();
	
	private Class<T> domainClass;
	private Logger logger;
	private char firstLetter;
	private String entityName;

	protected SimpleGenericDaoImpl(Class<T> type) {
		this.domainClass = type;
		this.logger = Logger.getLogger(domainClass.getName());
		firstLetter = domainClass.getSimpleName().charAt(0);
		this.entityName = domainClass.getSimpleName();
	}

	@Override
	public T save(T type) {
		logger.log(Level.INFO, "Saving entity {0} into database.", type);
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(type);
			this.entityManager.getTransaction().commit();
			return type;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to save object to database.");
			throw new SimpleGenericPersistenceException(e.getMessage());
		}
	}

	@Override
	public T update(T type) {
		try {
			this.entityManager.getTransaction().begin();
			boolean contains = this.entityManager.contains(type);
			if (contains) {
				this.entityManager.merge(type);
				this.entityManager.getTransaction().commit();
				return type;
			} else {
				save(type);
				return type;
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to update object into database.");
			throw new SimpleGenericPersistenceException(e.getMessage());
		}
	}

	@Override
	public void deleteById(ID id) {
		logger.log(Level.INFO, "Deleting entity by id {0}", id);
		try {
			this.entityManager.getTransaction().begin();
			T entity = this.entityManager.find(domainClass, id);
			if (entity == null)
				return;
			this.entityManager.remove(entity);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to delete object from database.");
			throw new SimpleGenericPersistenceException(e.getMessage());
		}

	}

	@Override
	public List<T> findAll() {
		logger.log(Level.INFO, "Find all elements from database.");
		String search = String.format("Select %s from %s %s", firstLetter, entityName, firstLetter);
		Query query = this.entityManager.createQuery(search, domainClass);
		@SuppressWarnings("unchecked")
		List<T> list = query.getResultList();

		if (list == null) {
			return new ArrayList<>();
		}
		return list;
	}

	@Override
	public T findById(ID id) {
		logger.log(Level.INFO, "Finding entity by id {0}", id);
		try {
			return this.entityManager.find(domainClass, id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to find object from database.");
			throw new SimpleGenericPersistenceException(e.getMessage());
		}
	}
	
	@Override
	public void delete(T t) {
		logger.log(Level.WARNING, "Deleting entity {0} from database.", t);
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(t);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unable to delete object from database.");
			throw new SimpleGenericPersistenceException(e.getMessage());	
	}
} 

	@Override
	public List<T> pagination(int begin, int size, String field, Ordering ordering) {
		logger.log(Level.INFO, "Getting all entities with pagination");
		String search = String.format("Select %s from %s %s Order by %s.%s %s", firstLetter, entityName, firstLetter, firstLetter, field, ordering.name());
		Query query = this.entityManager.createQuery(search, domainClass);
		@SuppressWarnings("unchecked")
		List<T> resultList = query.setMaxResults(size).getResultList();
		return resultList;
	}
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
