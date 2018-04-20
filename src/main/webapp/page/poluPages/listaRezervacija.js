ustanoveApp.controller('listaRezervacijaController', ['$scope','$state','$window','$http', function ($scope,$state,$window,$http) {
    //region meni
    $scope.jesamAdmin = false;
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
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    //endregion
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    });

    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloga = data2;
        $scope.ja.uloge.forEach(function (value) {
            console.log(value);
            if (value.naziv == $scope.uloga.naziv) {
                $scope.jesamAdmin = true;
            } else
                console.log("nema")
        })
    })


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