ustanoveApp.controller('ponudiController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {
    $scope.ponuda={}
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
    $scope.toOglasi = function () {
        $state.go("oglasi");
    }
    $scope.toPregled = function(id) {
        $state.go("pregledPonudaOglasa", {id: id});
    }
    $http.get('/api/rekvizit/' + $stateParams.id).success(function (data) {
        $scope.rekvizit = data;
    });
    $http.get('/api/korisnik/secured/ja').success(function (data) {
        $scope.ja = data;
    });

    $scope.postaviPonudu=function () {
        $scope.ponuda.ponudjac=$scope.ja;
        $scope.ponuda.oglas=$scope.rekvizit;
        $http.post('/api/ponuda/dodaj',$scope.ponuda).success(function (data) {
            console.log('Ponudjeno!');
            alert('Ponudjeno!');
            $scope.toPregled($scope.rekvizit.id);
        }).error(function () {
            alert('Greška pri dodavanju ponude');
        })
    }
}]);