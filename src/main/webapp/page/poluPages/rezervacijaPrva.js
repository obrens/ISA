ustanoveApp.controller('rezervacijaPrvaController', ['$scope','$state', function ($scope,$state) {

    $scope.toRez2 = function() {
        $state.go("rezervacijaDruga");
    }
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }

}]);