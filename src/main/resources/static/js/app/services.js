angular.module('myApp')
	.constant('CAR_ENDPOINT', 'api/cars/:id/')
	.constant('CUSTOMER_ENDPOINT', 'api/customers/:id/')
	.factory('Car', function ($resource, CAR_ENDPOINT) {
		return $resource(CAR_ENDPOINT);
	})
	.factory('Customer', function ($resource, CUSTOMER_ENDPOINT) {
		return $resource(CUSTOMER_ENDPOINT);
	})
	.service('CarService', function (Car) {
		this.getAll =  function (param) {
			return Car.query(param);
		};
		this.get = function (index) {
			return Car.get({id: index});
		};
		this.add = function (car) {
			car.$save();
		};
	})
	.service('CustomerService', function (Customer) {
		this.getAll =  function () {
			return Customer.query();
		};
	});