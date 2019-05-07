package pl.justynababinska.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.justynababinska.dto.CustomerDto;
import pl.justynababinska.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerEndpoint {

	CustomerService customerService;

	@Autowired
	public CustomerEndpoint(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CustomerDto> getCustomers() {
		List<CustomerDto> customers = customerService.getAll();
		return customers;
	}
}
