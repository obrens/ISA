ustanoveApp.controller('projekcijeIzmenaController', ['$scope', '$http','$state', '$stateParams', '$window', function ($scope, $http, $state, $stateParams, $window) {
    //region Meni
    $scope.toRez2 = function() {
        $state.go("rezervacijaDruga");
    };
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    };
    $scope.toListaRezervacija = function() {
        $state.go("listaRezervacija");
    };
    $scope.toIstorijaPoseta = function() {
        $state.go("istorijaPoseta");
    };
    $scope.toBioskopiLista = function() {
        $state.go("bioskopiLista");
    };
    $scope.toPrijateljiLista = function() {
        $state.go("prijateljiLista");
    };
    $scope.toFanzona = function() {
        $state.go("fanzona");
    };
    //endregion

    /*$http.get("/api/karta/secured/dostupniPopusti/" + $stateParams.idUstanove).success(function (data) {
        $scope.popusti = data;
    });

    $scope.obrisiPopust = function (id) {
        $http.delete("/api/karta/secured/obrisiPopust/" + id).success(function (){
            //$state.go("karteNaPopustuIzmena", {idUstanove: $stateParams.idUstanove});
            $window.location.reload();
        });
    };*/
}]);