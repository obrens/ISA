ustanoveApp.controller('novaProjekcijaController', ['$scope', '$state', '$http', '$stateParams', '$window', function ($scope, $state, $http, $stateParams, $window) {
    $http.get('/api/delo/secured/delaUstanove/' + $stateParams.id).success(function (data) {
        $scope.dela = data;
    });

    $http.get('/api/sala/secured/saleUstanove/' + $stateParams.id).success(function (data) {
        $scope.sale = data;
    });

    $scope.ima = true;
    $scope.napravi = function () {
        $http.post('/api/projekcija/secured/dodaj', $scope.dto).success(function () {
            $window.location.reload();
        })
    };
}]);