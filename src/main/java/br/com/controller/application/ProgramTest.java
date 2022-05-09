package br.com.controller.application;

import br.com.model.dao.ProductDAO;
import br.com.model.entities.Contact;
import br.com.model.entities.Product;

public class ProgramTest {
	public static void main(String[] args) {
		Contact contact = new Contact();
		contact.setId(1);

		ProductDAO productdao = new ProductDAO();
		Product product = new Product(3, "granola", 10, 15, contact);

		// productdao.update(product);

		// product = productdao.findById(3);
		// System.out.println(product.getDescricao());

		for (Product pro : productdao.findAll()) {
			System.out.println(pro.getDescricao());
		}

	}

}
