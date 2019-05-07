package pl.justynababinska.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.justynababinska.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
