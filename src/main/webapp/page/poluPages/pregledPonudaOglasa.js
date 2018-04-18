ustanoveApp.controller('pregledPonudaOglasaController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {
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
    $scope.toOglasi = function () {
        $state.go("oglasi");
    }
    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }

    $http.get('/api/rekvizit/' + $stateParams.id).success(function (data) {
        $scope.rekvizit = data;
    });

    $http.get('/api/ponuda/' + $stateParams.id).success(function (data) {
        $scope.ponude = data;
    });
}]);