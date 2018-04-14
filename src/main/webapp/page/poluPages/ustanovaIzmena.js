ustanoveApp.controller('ustanovaIzmenaController', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {
    //region Meni
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
    $scope.toPrijateljiLista = function () {
        $state.go("prijateljiLista");
    }
    $scope.toFanzona = function () {
        $state.go("fanzona");
    }
    //endregion

    $scope.popusti = function () {
        $state.go("karteNaPopustuIzmena", {id: $scope.ustanova.id});
    };

    $http.get('/api/ustanova/' + $stateParams.id).success(function (data) {
        $scope.ustanova = data;
    });

    $scope.azurirajUstanovu = function () {
        /*var final = {};
        final.id = $scope.ustanova.id;
        final.naziv = $scope.ustanova.naziv;
        final.opis = $scope.ustanova.opis;
        final.adresa = $scope.ustanova.adresa;*/
        $http.post('/api/ustanova/dodaj', $scope.ustanova).success(function (data) {
            $state.go("ustanova", {id: data});
        });
    };
}]);