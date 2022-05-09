package br.com.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
