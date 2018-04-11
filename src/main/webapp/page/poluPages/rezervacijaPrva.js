ustanoveApp.controller('rezervacijaPrvaController', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.toRez2 = function() {
        $state.go("rezervacijaDruga");
    }
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $http.get('/api/ustanova/sve').success(function (data) {
        $scope.bioskopi = data;
    });
}]);