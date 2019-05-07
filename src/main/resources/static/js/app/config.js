angular.module('myApp')
	.config(function ($routeProvider) {
		$routeProvider
			.when('/list', {
				templateUrl: 'views/list.html',
				controller: 'ListController',
				controllerAs: 'listCtrl'
			})
			.when('/details/:id', {
				templateUrl: 'views/details.html',
				controller: 'DetailsController',
				controllerAs: 'detailsCtrl'
			})
			.when('/newCar', {
				templateUrl: 'views/newCar.html',
				controller: 'NewEdit_UserController',
				controllerAs: 'newEdit_userCtrl'
			})
			.when('/editCar/:id', {
				templateUrl: 'views/newCar.html',
				controller: 'NewEdit_UserController',
				controllerAs: 'newEdit_userCtrl'
			})
			.otherwise({
				redirectTo: '/list'
			});
	});
