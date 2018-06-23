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

	// query all customers in the database
	public List<Customer> findAll() {
		System.out.println("Inside CustomerDAO.findAll...");
		System.out.println("Querying all customers... ");
		return manager.createQuery("select c from Customer c", Customer.class).getResultList();
	}

	// query customers based in zip code
	public List<Customer> findByZip(String zipCode) {
		System.out.println("Inside CustomerDAO.findByZip...");
		System.out.println("Querying customers by the zipCode: " + zipCode);
		return manager.createQuery("select c from Customer c where c.zipCode = :zipCode", Customer.class).getResultList();
	}

	// query customers based in geoPosition
	public List<Customer> findByGeoPosition(String geoPosition) {
		System.out.println("Inside CustomerDAO.findByGeoPosition...");
		System.out.println("Querying customers by the geoPosition: " + geoPosition);
		return manager.createQuery("select c from Customer c where c.geoPosition = :geoPosition", Customer.class).getResultList();
	}

}
