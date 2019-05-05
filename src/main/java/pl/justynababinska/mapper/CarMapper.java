package pl.justynababinska.mapper;

import pl.justynababinska.dto.CarDto;
import pl.justynababinska.model.Car;

public class CarMapper {

	public static CarDto toDto(Car car) {
		CarDto carDto = new CarDto();
		carDto.setId(car.getId());
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		carDto.setDescription(car.getDescription());
		carDto.setPrice(car.getPrice());
		return carDto;
	}
	
	public static Car toEntity(CarDto carDto) {
		Car car = new Car();
		car.setId(carDto.getId());
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		car.setDescription(carDto.getDescription());
		car.setPrice(carDto.getPrice());
		return car;
	}
}
