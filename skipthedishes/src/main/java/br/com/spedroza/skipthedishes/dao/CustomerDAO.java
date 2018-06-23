package br.com.spedroza.skipthedishes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spedroza.skipthedishes.model.Customer;

@Repository
@Transactional
public class CustomerDAO {

	@PersistenceContext
	private EntityManager manager;

	// insert a customer
	public void insert(Customer customer) {
		System.out.println("Inside CustomerDAO.insert...");
		manager.persist(customer);
	}

	// query customers in the database
	public List<Customer> findAll() {
		System.out.println("Inside CustomerDAO.findAll...");
		System.out.println("Querying all customers... ");
		return manager.createQuery("select c from Customer c", Customer.class).getResultList();
	}

}
