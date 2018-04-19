ustanoveApp.controller('odobriOglasController', ['$scope', '$http', '$state', '$stateParams', '$window', function ($scope, $http, $state, $stateParams, $window) {
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
    $scope.toPrijateljiLista = function () {
        $state.go("prijateljiLista");
    }
    $scope.toFanzona = function () {
        $state.go("fanzona");
    }
    $scope.toOglasi = function () {
        $state.go("oglasi");
    }
    $scope.uspesno = function () {
        $state.go("odobravanjeOglasa");
    }
    $scope.logout = function () {
        $window.location.href = '/logout';
    };

    $http.get('/api/rekvizit/' + $stateParams.id).success(function (data) {
        $scope.rekvizit = data;
    });

    $scope.odobri = function (x) {
        x.odobren = true;
        x.preuzet = true;
        $http.put('/api/rekvizit/secured/izmeni', x).success(function (data) {
            alert('Rekvizit uspešno dodat');
            $scope.uspesno();
        })
    }
    $scope.odbij = function (x) {
        $http.delete('/api/rekvizit/izbrisi/' + x.id).success(function (data) {
            alert('Rekvizit uspesno odbijen');
            $scope.uspesno();
        })
    }

}]);