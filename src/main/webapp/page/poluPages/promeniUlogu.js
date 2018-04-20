ustanoveApp.controller('promeniUloguController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    $scope.uloge=[]
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
    $scope.toNoviOglas = function() {
        $state.go("noviOglas");
    }
    $scope.toOglasi = function () {
        $state.go("oglasi");
    }
    $scope.logout = function() {
        $window.location.href = '/logout';
    }
    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloge.push(data2);
    })
    $http.get('/api/tip/4').success(function (data2) {
        $scope.uloge.push(data2);
    })

    $http.get('/api/korisnik/secured/svikorisnici').success(function (data) {
        $scope.korisnici=data;
    })

}]);