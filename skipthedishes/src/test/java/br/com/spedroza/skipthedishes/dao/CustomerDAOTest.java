package br.com.spedroza.skipthedishes.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.spedroza.skipthedishes.conf.JPAConfiguration;
import br.com.spedroza.skipthedishes.model.Customer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JPAConfiguration.class, CustomerDAO.class})
public class CustomerDAOTest {

	@Autowired
	CustomerDAO customerDao;
	
	@Test
	@Transactional
	public void testCustomerQuery() {
		List<Customer> customers = customerDao.findAll();
		Assert.assertEquals(100, customers.size());
	}
	
	@Test
	@Transactional
	public void testCustomerByZipQuery() {
		String zipCode = "V1X 4W0";
		List<Customer>customers = customerDao.findAll().stream().filter(c -> c.getZipCode().equalsIgnoreCase(zipCode.trim()))
				.collect(Collectors.toList());
		Assert.assertEquals("Cooper", customers.get(0).getName());
	}
	
	@Test
	@Transactional
	public void testCustomerByPosition() {
		String geoPosition = "69.7483, -31.61417";
		List<Customer>customers = customerDao.findAll().stream().filter(c -> c.getGeoPosition().equalsIgnoreCase(geoPosition.trim()))
				.collect(Collectors.toList());
		Assert.assertEquals("Quynn", customers.get(0).getName());
	}
}
