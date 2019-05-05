package pl.justynababinska.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.justynababinska.dto.CarDto;
import pl.justynababinska.mapper.CarMapper;
import pl.justynababinska.repository.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;

	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<CarDto> findAll() {
		return carRepository.findAll().stream().map(CarMapper::toDto).collect(Collectors.toList());
	}

	public List<CarDto> findAllByBrand(String brand) {
		return carRepository.findAllByBrandContainingIgnoreCase(brand).stream().map(CarMapper::toDto)
				.collect(Collectors.toList());
	}
}
