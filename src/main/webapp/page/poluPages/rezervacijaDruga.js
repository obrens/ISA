ustanoveApp.controller('rezervacijaDrugaController', ['$scope','$state', function ($scope,$state) {

        $scope.toRez3 = function() {
            $state.go("rezervacijaTreca");
        }
        $scope.toUserProfil = function() {
            $state.go("userProfil");
        }

}]);