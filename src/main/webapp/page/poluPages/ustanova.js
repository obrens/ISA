ustanoveApp.controller('ustanovaController', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {
    $http.get('/api/ustanova/' + $stateParams.id).success(function (data) {
        $scope.ustanova = data;
    });

    $scope.toPrvaRez=function (id) {
        $state.go("rezervacijaPrva", {id: id});
    }
    $scope.toBrzaRez=function (id) {
        $state.go("brzaRezervacija", {idUstanove: id});
    }
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
    }).error(function () {
        $scope.nijeNiko=true;
    });
}]);
