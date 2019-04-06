angular.module('myApp')

.controller('CarController', function($http){
    var vm = this;
    function refreshData(){
    	$http.get('api/cars')
            .then(function success(response){
                vm.cars = response.data;
                console.log(vm.cars);
            },function error(response){
            console.log('Error' + response.status);
            });
    }
    
    vm.addCar = function(car){
        $http.post('api/cars', car)
            .then(function success(response){
                refreshData();
                vm.car = {};
            },function error(response){
                console.log('Data not saved' + car)
            });
        }
    
    vm.appName = 'Car Manager';
    refreshData();
});