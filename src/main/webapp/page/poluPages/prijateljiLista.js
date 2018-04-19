ustanoveApp.controller('prijateljiListaController', ['$scope','$state','$window','$http', function ($scope,$state,$window,$http) {

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
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }
    $http.get('/api/korisnik/secured/ja').success(function (data) {
        $scope.ja = data;
    });
    $http.get('/api/korisnik/secured/svi').success(function (data) {
        $scope.prijatelji = data;
        var arrayLength = $scope.prijatelji.length;
        for (var i = 0; i < arrayLength; i++) {
            if ($scope.prijatelji[i].id===$scope.ja.id){
                console.log($scope.prijatelji[i].id+"aa"+$scope.ja.id)
                $scope.prijatelji.items.splice(i,1);
            }
        }
    });

    $scope.dodajPriku=function (id) {
        $http.put('/api/korisnik/secured/zahtevamPrijatelja/'+id).success(function () {
            alert("Zahtev za prijateljstvo poslat!");
        })
        $window.location.reload();
    }
    $scope.obrisiPriku=function (id) {
        $http.delete('/api/korisnik/secured/gubimPrijatelja/'+id).success(function () {
            alert("Prijatelj obrisan iz liste prijatelja");
        })
        $window.location.reload();
    }
}]);