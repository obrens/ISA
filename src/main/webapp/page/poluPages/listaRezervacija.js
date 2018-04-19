ustanoveApp.controller('listaRezervacijaController', ['$scope','$state','$window','$http', function ($scope,$state,$window,$http) {
    //region meni
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
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    //endregion
    $http.get('/api/korisnik/secured/ja').success(function (data) {
        $scope.ja = data;
    });
    $http.get('/api/karta/rezervacije').success(function (data) {
        $scope.rezervacije = data;
    });
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
    $scope.otkazi = function(id) {
        $http.put('/api/karta/otkazi/'+id).success(function () {
            $window.location.reload();
        })

    }

}]);