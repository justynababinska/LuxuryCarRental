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
			.when('/new', {
				templateUrl: 'views/new.html',
				controller: 'NewController',
				controllerAs: 'newCtrl'
			})
			.otherwise({
				redirectTo: '/list'
			});
	});
