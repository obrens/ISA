ustanoveApp.controller('saleController', ['$scope', '$http', '$state', '$stateParams', '$window', function ($scope, $http, $state, $stateParams, $window) {
    //region Meni
    $scope.toRez2 = function () {
        $state.go("rezervacijaDruga");
    };
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
    $scope.toPrijateljiLista = function () {
        $state.go("prijateljiLista");
    };
    $scope.toFanzona = function () {
        $state.go("fanzona");
    };
    //endregion

    $http.get("/api/sala/secured/saleUstanove/" + $stateParams.idUstanove).success(function (data) {
        $scope.sale = data;
    });

    $scope.izmeni = function (id) {
        $scope.sale.forEach(function (value) {
            if (id === value.id) {
                $http.put("/api/sala/secured/promeni", value).success(function () {
                    $window.location.reload();
                });
            }
        });
    };

    $scope.dodaj = function (id) {
        $http.post("/api/sala/secured/dodaj/" + $stateParams.idUstanove, $scope.sala).success(function () {
            $window.location.reload();
        });
    };
}]);