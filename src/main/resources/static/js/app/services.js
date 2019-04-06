angular.module('myApp')

.factory('Car', function(){
    function Car(model, brand, description, price){
        this.model = model;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }
    return Car;
});