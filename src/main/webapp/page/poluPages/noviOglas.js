ustanoveApp.controller('noviOglasController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state, $window) {
    $scope.rekvizit={}
    $scope.image={}
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
        $scope.rekvizit.oficijalni=false;
        $scope.rekvizit.odobren=false;
        $scope.rekvizit.korisnik=$scope.ja;
        $scope.rekvizit.slika=$scope.image.src;
        $http.post('/api/rekvizit/dodaj',$scope.rekvizit).success(function (data) {
            console.log('Rekvizit uspeho dodat'+$scope.image.src);
            alert('Rekvizit uspešno dodat');
            //$scope.cancel();
        }).error(function () {
            alert('Greška pri dodavanju rekvizita');
        })
    }
}]);