ustanoveApp.controller('istorijaPosetaController', ['$scope','$state','$window','$http', function ($scope,$state,$window,$http) {
    //region meni
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
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
    $http.get('/api/karta/posete').success(function (data) {
        $scope.posete = data;
        $scope.firstRate = 2;
        $scope.secondRate = data.ocenaProjekcije;
    });
    $scope.oceniAmbijent=function () {
        
    }
    $scope.oceniProjekciju=function () {
        
    }

}]);