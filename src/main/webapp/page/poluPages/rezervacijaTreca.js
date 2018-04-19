ustanoveApp.controller('rezervacijaTrecaController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {
    $scope.idKarte={};
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $scope.idKarte=$stateParams.id;
    $scope.zarezervuj=function(){
        $http.post('/api/karta/rezervisi/'+$scope.idKarte).success(function () {
            $state.go("userProfil");
        });
    }
}]);