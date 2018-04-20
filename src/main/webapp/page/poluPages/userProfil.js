ustanoveApp.controller('userProfilController', ['$scope', '$state', '$window', '$http', function ($scope, $state, $window, $http) {
    $scope.jesamAdmin = false;
    $scope.toRez2 = function () {
        $state.go("rezervacijaDruga");
    }
    $scope.toUserProfil = function () {
        $state.go("userProfil");
    }
    $scope.toListaRezervacija = function () {
        $state.go("listaRezervacija");
    }
    $scope.toIstorijaPoseta = function () {
        $state.go("istorijaPoseta");
    }
    $scope.toBioskopiLista = function () {
        $state.go("bioskopiLista");
    }
    $scope.toPozoristaLista = function () {
        $state.go("pozoristaLista");
    }
    $scope.toPrijateljiLista = function () {
        $state.go("prijateljiLista");
    }
    $scope.toFanzona = function () {
        $state.go("fanzona");
    }
    $scope.logout = function () {
        $window.location.href = '/logout';
    };
    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    }
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    });
    $http.get('/api/korisnik/secured/svi').success(function (data) {
        $scope.prijatelji = data;
    });

    $scope.dodajPriku = function (id) {
        $http.put('/api/korisnik/secured/zahtevamPrijatelja/' + id).success(function () {
            alert("Zahtev za prijateljstvo poslat!");
            $window.location.reload();
        })

    }
    $scope.obrisiPriku = function (id) {
        $http.delete('/api/korisnik/secured/gubimPrijatelja/' + id).success(function () {
            alert("Prijatelj obrisan iz liste prijatelja");
            $window.location.reload();
        })

    }
    $scope.azurirajCoveka = function () {
        console.log($scope.ja);
        $http.put('/api/korisnik/secured/izmeni', $scope.ja).success(function (data) {
            $window.location.href = '/logout';
        });
    }
    $scope.rifresuj = function () {
        $window.location.reload();
    }
    //$http.get('/api/korisnik/' + $scope.ja.id).success(function (dada) {
    //$scope.praviJa = dada;
    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloga = data2;
        $scope.ja.uloge.forEach(function (value) {
            console.log(value);
            if (value.naziv == $scope.uloga.naziv) {
                $scope.jesamAdmin = true;
                //$state.go("sistemStranica");
            } else
                console.log("nema")
        })

    })

    //})

}]);