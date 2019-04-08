angular.module('myApp')
	.constant('CAR_ENDPOINT', '/api/cars/:id')
	.factory('Car', function ($resource, CAR_ENDPOINT) {
		return $resource(CAR_ENDPOINT);
	})
	.service('Cars', function (Car) {
		this.getAll = function () {
			return Car.query();
		}
		this.get = function (index) {
			return Car.get({id: index});
		}
		this.add = function (car) {
			car.$save();
		}
	});