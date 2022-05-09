package br.com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.connection.ConnectionFactory;
import br.com.model.entities.Contact;

public class ContactDAO {

	public Contact save(Contact contact) {

		EntityManager em = new ConnectionFactory().getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(contact);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return contact;

	}

	public Contact update(Contact contact) {

		EntityManager em = new ConnectionFactory().getEntityManager();

		try {
			em.getTransaction().begin();
			if (contact.getId() == null) {
				em.persist(contact);
			} else {
				em.merge(contact);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return contact;
	}

	public Contact findById(Integer id) {

		EntityManager em = new ConnectionFactory().getEntityManager();
		Contact contact = null;
		try {
			contact = em.find(Contact.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return contact;

	}

	public List<Contact> findall() {
		EntityManager em = new ConnectionFactory().getEntityManager();
		List<Contact> contact = null;
		try {
			contact = em.createQuery("from Contact ").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			em.close();
		}
		return contact;
	}

	public Contact remove(Integer id) {
		EntityManager em = new ConnectionFactory().getEntityManager();
		Contact contact = null;
		;
		try {
			contact = em.find(Contact.class, id);
			em.getTransaction().begin();
			em.remove(contact);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return contact;

	}

}
