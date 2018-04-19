ustanoveApp.controller('rezervacijaTrecaController', ['$scope', '$http', '$state','$stateParams', function ($scope, $http, $state, $stateParams) {
    $scope.idKarte={};
    $scope.praviDrugari=[];
    $scope.zaZvanje=[];
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $scope.idKarte=$stateParams.id;
    $scope.zarezervuj=function(){
        $http.post('/api/karta/rezervisi/'+$scope.idKarte).success(function () {
            $state.go("userProfil");
        });
    }
    $scope.dodajGaNaListu=function () {
        $scope.zaZvanje.push($scope.selectedPrika);
        console.log($scope.zaZvanje);
    }
    $http.get('/api/korisnik/secured/svi').success(function (data) {
        $scope.prijatelji = data;
        $scope.prijatelji.forEach(function (value) {
            if(value.prijatelj){
                $scope.praviDrugari.push(value);
            }
        })
    });

}]);