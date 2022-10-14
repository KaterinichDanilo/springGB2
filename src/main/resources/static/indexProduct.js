angular.module('app', []).controller('indexProductController', function ($scope, $http) {
    const contextPath = 'http://localhost:8070/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changePrice = function (productId, delta){
        $http({
            url: contextPath + '/product/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productId){
        $http.get(contextPath + '/product/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            })
    }

    $scope.loadProducts();

});