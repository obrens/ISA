ustanoveApp.controller('rezervacijaPrvaController', ['$scope','$state','$http', function ($scope,$state,$http) {
    $scope.arejNaziva=[];
    $scope.arejDatuma=[];
    $scope.arejVremena=[];
    var nazivTr;
    $scope.selectedList={};
    $scope.toRez2 = function() {
        $state.go("rezervacijaDruga");
    }
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $http.get('/api/ustanova/sve').success(function (data) {
        $scope.bioskopi = data;
    });
    $scope.nadjiProjekcije=function () {
        $scope.arejNaziva=[];
        $scope.arejDatuma=[];
        $scope.arejVremena=[];
        $http.get('/api/projekcija/projekcijeUstanove/'+ $scope.selectedUstanova.id).success(function (data) {
            $scope.selectedList.projekcije = data;

            $scope.selectedList.projekcije.forEach(function (value) {
                if ($scope.arejNaziva.includes(value.nazivDela)){

                }else{
                    $scope.arejNaziva.push(value.nazivDela);
                }
            })
        });
    }
    $scope.nadjiDatume=function () {
        $scope.arejDatuma=[];
        $scope.arejVremena=[];
        $scope.selectedList.projekcije.forEach(function (value) {
            if(value.nazivDela===$scope.selectedDelo){
                $scope.arejDatuma.push(value.datum);
                nazivTr=$scope.selectedDelo;
            }
        })
        console.log($scope.arejDatuma);
    }
    /*$scope.nadjiVreme=function () {
        fLen = arejDatuma.length;
        for (i = 0; i < fLen; i++) {
            if(arejDatuma[i]==$scope.selectedDatum.datum){
                arejVremena.push([$scope.selectedDatum.nazivDela,$scope.selectedDatum.datum,$scope.selectedDatum.datum]);
            }
        }
        //console.log(arejVremena);
    }*/

}]);