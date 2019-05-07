package pl.justynababinska.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CarDto getCarById(@PathVariable(name = "id") Long id) {
		return carService.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCar(@RequestBody CarDto carDto) {
		carService.save(carDto);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCar(@PathVariable(name = "id") Long id, @RequestBody CarDto carDto) {
		CarDto car = carService.findById(id);
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		car.setDescription(carDto.getDescription());
		car.setPrice(carDto.getPrice());
		carService.save(car);
	}
}
