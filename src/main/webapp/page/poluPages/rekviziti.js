ustanoveApp.controller('fanzonaController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    $scope.jesamAdmin = false;
    $scope.jesamFan = false;
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
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $scope.toFanAdmin=function () {
        $state.go("fanAdmin");
    }
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
        console.log($scope.ja);
    });
    $http.get('/api/rekvizit/secured/svi').success(function (data) {
        $scope.rekviziti = data;
        $scope.oficialni=[];
        $scope.neoficialni=[];
        $scope.rekviziti.forEach(function (value) {
            if(value.oficijalni==true)
                $scope.oficialni.push(value);
            else
                $scope.neoficialni.push(value);
        })
    });
    $scope.rezervisi = function (x) {
        $http.delete('/api/rekvizit/izbrisi/' + x).success(function (data) {
            $http.get('/api/rekvizit/secured/svi').success(function (data) {
                alert("Rezervisano!");
                $scope.rekviziti = data;
                $scope.oficialni=[];
                $scope.neoficialni=[];
                $scope.rekviziti.forEach(function (value) {
                    if(value.oficijalni==true)
                        $scope.oficialni.push(value);
                    else
                        $scope.neoficialni.push(value);
                })
            });
        })
    }

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
}]);