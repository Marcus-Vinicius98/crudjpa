package br.com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.connection.ConnectionFactory;
import br.com.model.entities.Product;

public class ProductDAO {

	public Product save(Product product) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return product;

	}

	public Product update(Product product) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		try {
			em.getTransaction().begin();
			if (product.getId() == null) {
				em.persist(product);
			} else {
				em.merge(product);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return product;

	}

	public Product findById(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return product;

	}

	public List<Product> findAll() {
		EntityManager em = new ConnectionFactory().getEntityManager();
		List<Product> product = null;
		try {
			product = em.createQuery("from Product").getResultList();
		} catch (Exception e) {
              System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return product;
	}

}
