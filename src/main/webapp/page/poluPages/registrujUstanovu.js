ustanoveApp.controller('registrujUstanovuController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    $scope.ustanova={}
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
    $scope.logout = function() {
        $window.location.href = '/logout';
    }
    $http.get('/api/tip/3').success(function (data2) {
        $scope.uloga=data2;
    })

    $http.get('/api/korisnik/secured/svikorisnici').success(function (data) {
        $scope.korisnici=data;
    })
    
    $scope.kreirajUstanovu=function () {
        if($scope.ustanovaTip)
        {
            $scope.ustanova.vrstaUstanove=true;
        }else
            $scope.ustanova.vrstaUstanove=false;

        $http.get('/api/korisnik/' + $scope.izabranAdmin.id).success(function (data1) {
            $scope.ustanova.admin=data1;
            data1.uloge.push($scope.uloga);
            $http.post('/api/ustanova/dodaj',$scope.ustanova).success(function (data) {
                console.log('Ustanova uspešno dodata');
                //alert('Ustanova uspešno dodata');
                $http.put('/api/korisnik/secured/izmeni', data1).success(function (data5) {
                    alert('Ustanova uspešno dodata');
                    $state.go("sistemStranica");
                })
            }).error(function () {
                alert('Greška pri dodavanju ustanove');
            });
        })

    }
}]);