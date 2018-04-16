ustanoveApp.controller('rezervacijaPrvaController', ['$scope','$state','$http', function ($scope,$state,$http) {

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
        $http.get('/api/projekcija/projekcijeUstanove/'+ $scope.selectedUstanova.id).success(function (data) {
            $scope.selectedList.projekcije = data;
        });
        /*angular.forEach($scope.selectedList.projekcije, function (value, key) {
            var d = 'Neunistivi';         // DATE TO COMPARE (A SPECIFIED DATE).
            d = $filter('date')(d, 'shortDate');

            var d1 = new Date();
            d1 = $filter('date')(key, 'shortDate');

            //CHECK IF THE DATE IN OBJECT IS GREATER THAN OR EQUAL TO THE SPECIFIED DATE.
            if (Date.parse(d1) >= Date.parse(d)) {
                // SHOW THE EXTRACTED DATA.
                console.log(key + ": " + value.name + ": " + value.age);
            }
        });*/
    }
    /*$scope.prikaziDatume=function () {
        $scope.datumi=$scope.selectedDelo;
    }*/

}]);