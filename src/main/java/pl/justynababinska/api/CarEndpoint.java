package pl.justynababinska.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pl.justynababinska.model.Car;
import pl.justynababinska.repository.CarRepository;

@RestController
@RequestMapping("api/cars")
public class CarEndpoint {

	private CarRepository carRepository;

	@Autowired
	public CarEndpoint(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getCars(@RequestParam(name = "brand", required = false) String brand) {
		List<Car> allCars = null;
		if (brand != null) {
			allCars = carRepository.findAllByBrandContainingIgnoreCase(brand);
		} else {
			allCars = carRepository.findAll();
		}
		return ResponseEntity.ok(allCars);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> getCarById(@PathVariable(name = "id") Long id) {
		Car car = carRepository.findById(id).get();
		if (car != null) {
			return ResponseEntity.ok(car);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveCar(@RequestBody Car car) {
		Car save = carRepository.save(car);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(location).body(save);
	}

}
