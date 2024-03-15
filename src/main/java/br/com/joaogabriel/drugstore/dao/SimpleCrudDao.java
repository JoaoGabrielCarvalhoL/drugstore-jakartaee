package br.com.joaogabriel.drugstore.dao;

import java.util.List;

import br.com.joaogabriel.drugstore.dao.enumerations.Ordering;
import jakarta.persistence.EntityManager;

public interface SimpleCrudDao<T, ID> {

	T save(T type);

	T update(T update);

	void deleteById(ID id);
	
	void delete(T t);

	List<T> findAll();
	
	List<T> pagination(int begin, int size, String field, Ordering ordering);

	T findById(ID id);
	
	EntityManager getEntityManager();
}
