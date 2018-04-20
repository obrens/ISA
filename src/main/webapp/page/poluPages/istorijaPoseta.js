ustanoveApp.controller('istorijaPosetaController', ['$scope', '$state', '$window', '$http', function ($scope, $state, $window, $http) {
    $scope.jesamAdmin = false;
    //region meni
    $scope.toUserProfil = function () {
        $state.go("userProfil");
    };
    $scope.toListaRezervacija = function () {
        $state.go("listaRezervacija");
    };
    $scope.toIstorijaPoseta = function () {
        $state.go("istorijaPoseta");
    };
    $scope.toBioskopiLista = function () {
        $state.go("bioskopiLista");
    };
    $scope.toPozoristaLista = function() {
        $state.go("pozoristaLista");
    }
    $scope.toPrijateljiLista = function () {
        $state.go("prijateljiLista");
    };
    $scope.toFanzona = function () {
        $state.go("fanzona");
    };
    $scope.toSistem=function () {
        $state.go("sistemStranica");
    }
    $scope.logout = function () {
        $window.location.href = '/logout';
    };
    //endregion
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    });
    $scope.orderByMe = function (x) {
        $scope.myOrderBy = x;
    };
    $http.get('/api/karta/posete').success(function (data) {
        $scope.posete = data;
        $scope.firstRate = 2;
        $scope.secondRate = data.ocenaProjekcije;
    });
    $scope.oceniAmbijent = function (kartaId) {
        $scope.posete.forEach(function (value) {
            if (kartaId === value.kartaId){
                $http.put('/api/karta/secured/oceniAmbijent', value).success(function () {
                    alert("E dobro ga i oceni!");
                });
            }
        });
    };
    $scope.oceniProjekciju = function (kartaId) {
        $scope.posete.forEach(function (value) {
           if (kartaId === value.kartaId){
               $http.put('/api/karta/secured/oceniProjekciju', value).success(function () {
                   alert("E dobro ga i oceni!");
               });
           }
        });
    };
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
}]);