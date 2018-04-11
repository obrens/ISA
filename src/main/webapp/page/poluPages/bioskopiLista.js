ustanoveApp.controller('bioskopiListaController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
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



    $scope.toUstanova = function(id) {
        $state.go("ustanova", {id: id});
    }

    $scope.toRegister = function() {
        $state.go("register");
    }

    $http.get('/api/ustanova/sve').success(function (data) {
        $scope.bioskopi = data;
    });
}]);



















































































