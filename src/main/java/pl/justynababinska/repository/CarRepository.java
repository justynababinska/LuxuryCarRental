package pl.justynababinska.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.justynababinska.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	List<Car> findAllByBrandContainingIgnoreCase(String brand);
}
