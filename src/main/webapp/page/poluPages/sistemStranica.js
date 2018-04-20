ustanoveApp.controller('sistemStranicaController', ['$scope', '$http', '$state', function ($scope, $http, $state) {
    $scope.jesamAdmin = true;
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


    $scope.toPromeni = function () {
        $http.get('/api/korisnik/' + $scope.ja.id).success(function (dada) {
            $scope.praviJa = dada;
            $http.get('/api/tip/1').success(function (data2) {
                $scope.uloga = data2;
                $scope.praviJa.uloge.forEach(function (value) {
                    console.log(value);
                    if (value.naziv==$scope.uloga.naziv) {
                        $scope.jesamAdmin=true;
                        $state.go("promeniUlogu");
                    }else
                        console.log("nema")
                })

            })
        })
    }
    $scope.toRegistruj = function () {
        $http.get('/api/korisnik/' + $scope.ja.id).success(function (dada) {
            $scope.praviJa = dada;
            $http.get('/api/tip/1').success(function (data2) {
                $scope.uloga = data2;
                $scope.praviJa.uloge.forEach(function (value) {
                    console.log(value);
                    if (value.naziv==$scope.uloga.naziv) {
                        $scope.jesamAdmin=true;
                        $state.go("registrujUstanovu");
                    }else
                        console.log("nema")
                })

            })
        })
    }
    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloga = data2;
    })

    $http.get('/api/korisnik/secured/ja').success(function (data) {
        $scope.ja = data;
    });

}])