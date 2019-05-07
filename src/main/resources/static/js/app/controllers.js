angular.module('myApp')
	.controller('ListController', function (CarService) {
		var vm = this;
		vm.cars = CarService.getAll();
		vm.search = function (brand) {
			vm.cars = CarService.getAll({brand});
		}
	})
	.controller('DetailsController', function ($routeParams, CarService) {
		var vm = this;
		var carIndex = $routeParams.id;
		vm.car = CarService.get(carIndex);
	})
	.controller('NewEdit_UserController', function ($routeParams, Car, CarService) {
		var vm = this;
		var carId = $routeParams.id;
		if(carId)
			vm.car = CarService.get(carId);
		else
			vm.car = new Car();
		
		vm.saveCar = function () {
			CarService.add(vm.car);
			vm.car = new Car();
		}
	})
	.controller('List_CustomerController', function(CustomerService) {
		var vm = this;
		vm.customers = CustomerService.getAll();
	});