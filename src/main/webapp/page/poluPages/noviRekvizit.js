ustanoveApp.controller('noviRekvizitOglasaController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state, $window) {
    $scope.rekvizit={}
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
    }
    $http.get('/api/korisnik/secured/ja').success(function (data) {
        $scope.ja = data;
    });

    $scope.napraviRekvizit=function () {
        $scope.rekvizit.oficijalni=true;
        $scope.rekvizit.odobren=true;
        $scope.rekvizit.korisnik=$scope.ja;
        $http.post('/api/rekvizit/dodaj',$scope.rekvizit).success(function (data) {
            console.log('Rekvizit uspeho dodat');
            alert('Rekvizit uspešno dodat');
            //$scope.cancel();
        }).error(function () {
            alert('Greška pri dodavanju rekvizita');
        })
    }
}]);