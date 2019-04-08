angular.module('myApp')
	.controller('ListController', function (Cars) {
		var vm = this;
		vm.cars = Cars.getAll();
	})
	.controller('DetailsController', function ($routeParams, Cars) {
		var vm = this;
		var carIndex = $routeParams.id;
		vm.car = Cars.get(carIndex);
	})
	.controller('NewController', function (Car, Cars) {
		var vm = this;
		vm.car = new Car();
		vm.saveCar = function () {
			Cars.add(vm.car);
			vm.car = new Car();
		}
	});