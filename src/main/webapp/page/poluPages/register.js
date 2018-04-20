ustanoveApp.controller('registerController', ['$scope','$state','$http','$window', function ($scope,$state,$http,$window) {
    $scope.korisnik={}
    $scope.toLogin = function() {
        $window.location.href = '/login';
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