ustanoveApp.controller('loginController', ['$scope','$state', function ($scope,$state) {
    $scope.user = {};
    $scope.title="vuko";
    $scope.items = ['home','about','contact','crr'];

    $scope.toRegister = function() {
        $state.go("register");
    }
}]);