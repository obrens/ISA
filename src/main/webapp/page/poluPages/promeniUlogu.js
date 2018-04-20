ustanoveApp.controller('promeniUloguController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    $scope.uloge=[]
    $scope.ulogeIzabr=[];
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
    $http.get('/api/tip/1').success(function (data2) {
        $scope.uloge.push(data2);
    })
    $http.get('/api/tip/4').success(function (data2) {
        $scope.uloge.push(data2);
    })
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    });

    $http.get('/api/korisnik/secured/svikorisnici').success(function (data) {
        $scope.korisnici = data;
        var arrayLength = $scope.korisnici.length;
        for (var i = 0; i < arrayLength; i++) {
            if ($scope.korisnici[i].id===$scope.ja.id){
                $scope.korisnici.splice(i,1);
            }
        }
    })
    $scope.nadjiUloge=function () {
        $scope.ulogeIzabr=[];
        $scope.korisnici.forEach(function (value) {
            if (value.id===$scope.izabranKorisnik.id){
                value.uloge.forEach(function (value2) {
                    $scope.ulogeIzabr.push(value2);
                    var ulogeIzLen=$scope.ulogeIzabr.length;
                    var ulogeLen=$scope.ulogeIzabr.length;
                    for(var i=0;i<ulogeLen;i++){
                        for(var j=0;j<ulogeIzLen;i++){
                            console.log($scope.uloge[i].naziv+" je "+$scope.ulogeIzabr[j].naziv)
                            if($scope.uloge[i].naziv===$scope.ulogeIzabr[j].naziv){
                                console.log($scope.ulogeIzabr);
                                $scope.uloge.splice(i,1);
                            }
                        }

                    }
                })

            }
        })
    }
}]);