angular.module('app').controller('orderConfirmationController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'localhost:5555';

    $scope.loadCart = function () {
        $http.get(contextPath + '/api/v1/cart/' + $localStorage.CartUuid)
            .then(function (response) {
                $scope.UserCart = response.data;
            });
    }

    $scope.submitOrder = function () {
        $http({
            url: contextPath + '/api/v1/orders',
            method: 'POST',
            params: {
                cartUuid: $localStorage.CartUuid,
                address: $scope.order_info.address
            }
        }).then(function (response) {
            $location.path('/order_result/' + response.data.id);
        });
    }

    $scope.loadCart();
});