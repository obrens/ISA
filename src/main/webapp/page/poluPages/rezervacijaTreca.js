ustanoveApp.controller('rezervacijaTrecaController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {

    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    idKarte=$stateParams.id;
    $scope.zarezervuj=function(){
        $http.post('/api/karta/rezervisi/'+idKarte).success(function () {
            $state.go("userProfil");
        });
    }
}]);