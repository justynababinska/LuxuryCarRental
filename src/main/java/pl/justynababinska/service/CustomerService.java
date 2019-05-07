package pl.justynababinska.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.justynababinska.dto.CustomerDto;
import pl.justynababinska.mapper.CustomerMapper;
import pl.justynababinska.repository.CustomerRepository;

@Service
public class CustomerService {

	CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<CustomerDto> getAll(){
		return customerRepository.findAll().stream().map(CustomerMapper::toDto).collect(Collectors.toList());
	}
}
