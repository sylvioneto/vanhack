package br.com.spedroza.skipthedishes.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.spedroza.skipthedishes.dao.CustomerDAO;
import br.com.spedroza.skipthedishes.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	/*
	 *  this method will get the customers in the DB and after that apply the filter is any parameter was given
	 *  I used the cache annotation to avoid many database connections
	 */
	@RequestMapping(method = RequestMethod.GET)
	@Cacheable(value = "customerList")
	public ModelAndView find(String zipCode, String geoPosition) {
		System.out.println("Inside CustomerController.findAll");
		ModelAndView modelAndView = new ModelAndView("/customer/list");
		List<Customer> customers = customerDAO.findAll();
		System.out.println("List size before filter: " + customers.size());
		
		// check if the requester send any parameter
		if (zipCode != null && !zipCode.isEmpty()) {
			customers = customers.stream().filter(c -> c.getZipCode().equalsIgnoreCase(zipCode.trim()))
					.collect(Collectors.toList());
		}
		if (geoPosition != null && !geoPosition.isEmpty()) {
			customers = customers.stream().filter(c -> c.getGeoPosition().equalsIgnoreCase(geoPosition.trim()))
					.collect(Collectors.toList());
		}

		System.out.println("List size after filter: " + customers.size());
		System.out.println("Setting customer list...");
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}
}
