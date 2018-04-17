ustanoveApp.controller('bioskopiListaController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    //region Meni
    $scope.toRez2 = function() {
        $state.go("rezervacijaDruga");
    }
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $scope.toListaRezervacija = function() {
        $state.go("listaRezervacija");
    }
    $scope.toIstorijaPoseta = function() {
        $state.go("istorijaPoseta");
    }
    $scope.toBioskopiLista = function() {
        $state.go("bioskopiLista");
    }
    $scope.toPrijateljiLista = function() {
        $state.go("prijateljiLista");
    }
    $scope.toFanzona = function() {
        $state.go("fanzona");
    }
    //endregion
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
    $scope.toUstanova = function(id) {
        $state.go("ustanova", {id: id});
    };

    $scope.toRegister = function() {
        $state.go("register");
    };

    $http.get('/api/ustanova/secured/sve').success(function (data) {
        $scope.bioskopi = data;
    });
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
}]);



















































































