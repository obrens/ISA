ustanoveApp.controller('registerController', ['$scope','$state','$http', function ($scope,$state,$http) {
    $scope.korisnik={}
    $scope.toLogin = function() {
        $state.go("login");
    }
    $scope.registruj=function () {
        if($scope.korisnik.lozinka!==$scope.passwordR){
            alert("Greska kod unosa lozinke!");
        }else{
            $http.post('/api/korisnik/registruj',$scope.korisnik).success(function () {
                alert('Korisnik uspešno dodat');
            }).error(function () {
                alert('Greška pri dodavanju korisnika');
            });
        }
    }
}]);