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
            $scope.zaZvanje.toString();
            console.log($scope.zaZvanje)
            $http.post('/api/korisnik/invite',$scope.zaZvanje).success(function () {
                alert('Poslani mejlovi!');
            }).error(function () {
                alert('Greška pri slanju');
            });
            $state.go("userProfil");
        });

    }
    $scope.dodajGaNaListu=function () {
        if ($scope.zaZvanje.includes($scope.selectedPrika)){

        }else{
            $scope.zaZvanje.push($scope.selectedPrika);
        }
        //console.log($scope.zaZvanje);
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