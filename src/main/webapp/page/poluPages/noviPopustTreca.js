ustanoveApp.controller('noviPopustTrecaController', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {

    $scope.toUserProfil = function () {
        $state.go("userProfil");
    };
    idKarte = $stateParams.id;
    $scope.napravi = function () {
        var popust = {kartaId: $stateParams.id, cena: $scope.novaCena};
        $http.post('/api/karta/dodajPopust', popust).success(function () {
            $state.go("userProfil");
        });
    };
}]);