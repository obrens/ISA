ustanoveApp.controller('rezervacijaPrvaController', ['$scope','$state','$http','$filter', function ($scope,$state,$http,$filter) {
    var recnikDela={}
    $scope._users = [
        {
            "User": {
                "userid": "19571",
                "status": "7",
                "active": "1",
                "lastlogin": "1339759025307",
                "Stats": [
                    {
                        "active": "1",
                        "catid": "10918",
                        "typeid": "71",
                        "Credits": [
                            {
                                "content": "917,65",
                                "active": "1",
                                "type": "C7"},
                            {
                                "content": "125,65",
                                "active": "1",
                                "type": "B2"}
                        ]}
                ]
            }}];
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
        /*angular.forEach($scope.selectedList.projekcije, function(value, key){
            for(var keyK in recnikDela){
                var valueK=recnikDela[key];
                    if(value.nazivDela === valueK.nazivDela){

                    }
            }
        });*/
        $scope.isActive = function(projekcija) {
            return projekcija[0].nazivDela === $scope.selectedDelo;
        };
    }



}]);