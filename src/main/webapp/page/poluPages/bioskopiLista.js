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
    $scope.toPozoristaLista = function() {
        $state.go("pozoristaLista");
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

    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    });
    $http.get('/api/ustanova/secured/bioskopi').success(function (data) {
        $scope.bioskopi = data;
    });
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    $scope.toRezervacija=function (id) {
        $state.go("rezervacijaPrva", {id: id});
    }
}]);



















































































