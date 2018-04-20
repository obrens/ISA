ustanoveApp.controller('laznaPozoristaController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
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
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
    $scope.toUstanova = function(id) {
        $state.go("ustanova", {id: id});
    };
    $http.get('/api/ustanova/secured/pozorista').success(function (data) {
        $scope.bioskopi = data;
    });
}]);