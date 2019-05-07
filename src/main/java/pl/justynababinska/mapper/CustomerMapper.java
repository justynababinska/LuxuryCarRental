package pl.justynababinska.mapper;

import pl.justynababinska.dto.CustomerDto;
import pl.justynababinska.model.Customer;

public class CustomerMapper {

	public static CustomerDto toDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setMobile(customer.getMobile());
		customerDto.setAddress(customer.getAddress());
		customerDto.setIdentityCard(customer.getIdentityCard());
		return customerDto;
	}
	
	public static Customer toEntity(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setId(customerDto.getId());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobile(customerDto.getMobile());
		customer.setAddress(customerDto.getAddress());
		customer.setIdentityCard(customerDto.getIdentityCard());
		return customer;
	}
}
