package br.com.controller.application;

import br.com.model.dao.ContactDAO;
import br.com.model.entities.Contact;

public class Program {
	public static void main(String[] args) {
		Contact pessoa = Contact.builder()
				.name("Marcus")
				.email("marcus@hotmail.com")
				.build();
				
		ContactDAO contactdao = new ContactDAO();
         
	        contactdao.save(pessoa);
	        
	        
	        
	        
	}

}
