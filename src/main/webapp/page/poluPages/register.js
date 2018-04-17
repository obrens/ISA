ustanoveApp.controller('registerController', ['$scope','$state', function ($scope,$state) {
    $scope.toLogin = function() {
        $state.go("login");
    }
}]);