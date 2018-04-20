ustanoveApp.controller('pocetnaNeprijavljeniController', ['$scope','$state','$window', function ($scope,$state,$window) {
    $scope.toBioskopiLista = function() {
        $state.go("lazniBioskopi");
    }
    $scope.toPozoristaLista = function() {
        $state.go("laznaPozorista");
    }
    $scope.toLogin = function() {
        $window.location.href = '/login';
    };
    $scope.toRegister = function() {
        $state.go("register");
    }


}]);