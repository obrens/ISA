ustanoveApp.controller('rezervacijaDrugaController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {
    $scope.arejRedova=[];
    $scope.arejSedista=[];
    var redTr,sedisteTr,idTr;
    $scope.ima=false;
    $scope.toRez3 = function() {
        $state.go("rezervacijaTreca");
    }
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $http.get('/api/karta/karteZaProjekciju/'+ $stateParams.id).success(function (data) {
        $scope.karte =data;

        $scope.karte.forEach(function (value) {
            if ($scope.arejRedova.includes(value.red)){

            }else{
                $scope.arejRedova.push(value.red);
            }
        })
    });
    $scope.nadjiSediste=function () {
        $scope.ima=false;
        $scope.arejSedista=[];
        $scope.karte.forEach(function (value) {
            if(value.red===$scope.selectedRed){
                if ($scope.arejSedista.includes(value.sediste)){

                }else{
                    $scope.arejSedista.push(value);
                }
                redTr=$scope.selectedRed;
            }
        })
        $scope.arejSedista.forEach(function (value) {
            if(value.rezervisana){
                value.sediste= value.sediste+" - Rezervisano";
            }
        })
    }
    $scope.kompletiraj=function () {
        sedisteTr=$scope.selectedSediste;
        $scope.karte.forEach(function (value) {
            if(value.red==redTr && value.sediste==sedisteTr){
                idTr=value.id;
                $scope.ide=idTr;
                $scope.ima=true;
            }
        })
    }
    $scope.toRez3 = function(id) {
        $state.go("rezervacijaTreca", {id: id});
    }
}]);