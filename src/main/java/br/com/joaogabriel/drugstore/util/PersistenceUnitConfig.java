package br.com.joaogabriel.drugstore.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.drugstore.exception.PersistenceUnitException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUnitConfig {

	private EntityManagerFactory entityManagerFactory = null;
	private static PersistenceUnitConfig instance = null;
	private final Logger logger = Logger.getLogger(PersistenceUnitConfig.class.getName());

	private PersistenceUnitConfig() {
		createEntityManagerFactory();
	}

	public static synchronized PersistenceUnitConfig getInstance() {
		if (instance == null) {
			instance = new PersistenceUnitConfig();
		}
		return PersistenceUnitConfig.instance;
	}

	private EntityManagerFactory createEntityManagerFactory() {
		try {
			this.entityManagerFactory = Persistence.createEntityManagerFactory("drugstorePersistenceUnitTest");
			return this.entityManagerFactory;
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Unable to create entity manager factory");
			throw new PersistenceUnitException(exception.getMessage());
		}
	}

	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}
}
