ustanoveApp.controller('registerController', ['$scope','$state', function ($scope,$state) {
    $scope.user = {};
    $scope.title="vukoa";
    $scope.items = ['homea','abouta','contacta','crra'];

    $scope.toLogin = function() {
        $state.go("login");
    }
}]);