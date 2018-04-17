ustanoveApp.controller('registerController', ['$scope','$state', function ($scope,$state) {
    $scope.user={}
    $scope.toLogin = function() {
        $state.go("login");
    }
    $scope.registruj=function () {
        if($scope.user.password!==$scope.user.passwordR){
            alert("Greska kod unosa lozinke!");
        }else{

        }
    }
}]);