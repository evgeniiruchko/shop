angular.module('app').controller('cartController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'localhost:5555';

    $scope.clearCart = function () {
        $http({
            url: contextPath + '/api/v1/cart/clear',
            method: 'POST',
            params: {
                uuid: $localStorage.CartUuid
            }
        }).then(function (response) {
            $scope.loadCart();
        });
    }

    $scope.createOrder = function () {
        $http.get(contextPath + '/api/v1/orders/create')
            .then(function (response) {
                $scope.showMyOrders();
                $scope.showCart();
            });
    }

    $scope.loadCart = function () {
        $http.get(contextPath + '/api/v1/cart/' + $localStorage.CartUuid)
            .then(function (response) {
                $scope.UserCart = response.data;
            });
    }

    $scope.goToOrderSubmit = function () {
        $location.path('/order_confirmation');
    }

    $scope.goToOrderSubmit = function () {
        $location.path('/order_confirmation');
    }

    $scope.loadCart();
});