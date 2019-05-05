package pl.justynababinska.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.justynababinska.dto.CarDto;
import pl.justynababinska.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarEndpoint {

	private CarService carService;

	@Autowired
	public CarEndpoint(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CarDto> getCars(@RequestParam(name = "brand", required = false) String brand) {
		List<CarDto> allCars = null;
		if (brand != null) {
			allCars = carService.findAllByBrand(brand);
		} else {
			allCars = carService.findAll();
		}
		return allCars;
	}

	/*
	 * @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<Car> getCarById(@PathVariable(name = "id") Long id) {
	 * Car car = carRepository.findById(id).get(); if (car != null) { return
	 * ResponseEntity.ok(car); } else { return ResponseEntity.notFound().build(); }
	 * 
	 * }
	 * 
	 * @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<?> saveCar(@RequestBody Car car) { Car save =
	 * carRepository.save(car); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (save.getId()) .toUri(); return ResponseEntity.created(location).body(save);
	 * }
	 */

}
