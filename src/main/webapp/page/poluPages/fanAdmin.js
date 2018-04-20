ustanoveApp.controller('fanAdminController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state, $window) {
    $scope.jesamAdmin = false;
    $scope.jesamFan = false;
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
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $scope.toFanAdmin=function () {
        $state.go("fanAdmin");
    }
    $scope.logout = function () {
        $window.location.href = '/logout';
    };
    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    }
    $scope.toSistem=function () {
        $state.go("fanAdmin");
    }
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
        console.log($scope.ja);
    });

    $scope.toPromeni = function () {
        $http.get('/api/korisnik/' + $scope.ja.id).success(function (dada) {
            $scope.praviJa = dada;
            $http.get('/api/tip/4').success(function (data2) {
                $scope.uloga = data2;
                $scope.praviJa.uloge.forEach(function (value) {
                    console.log(value);
                    if (value.naziv==$scope.uloga.naziv) {
                        $scope.jesamAdmin=true;
                        $state.go("odobravanjeOglasa");
                    }else
                        console.log("nema")
                })

            })
        })
    }
    $scope.toRegistruj = function () {
        $http.get('/api/korisnik/' + $scope.ja.id).success(function (dada) {
            $scope.praviJa = dada;
            $http.get('/api/tip/4').success(function (data2) {
                $scope.uloga = data2;
                $scope.praviJa.uloge.forEach(function (value) {
                    console.log(value);
                    if (value.naziv==$scope.uloga.naziv) {
                        $scope.jesamAdmin=true;
                        $state.go("noviRekvizit");
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
    $http.get('/api/tip/4').success(function (data2) {
        $scope.uloga = data2;
        $scope.ja.uloge.forEach(function (value) {
            console.log(value);
            if (value.naziv == $scope.uloga.naziv) {
                $scope.jesamFan = true;
            } else
                console.log("nema")
        })

    })

    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloga1 = data2;
        $scope.ja.uloge.forEach(function (value) {
            console.log(value);
            if (value.naziv == $scope.uloga1.naziv) {
                $scope.jesamAdmin = true;
            } else
                console.log("nema")
        })

    })
}])