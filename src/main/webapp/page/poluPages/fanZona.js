ustanoveApp.controller('fController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
    $scope.toUserProfil = function() {
        $state.go("userProfil");
    }
    $scope.toListaRezervacija = function() {
        $state.go("listaRezervacija");
    }
    $scope.toIstorijaPoseta = function() {
        $state.go("istorijaPoseta");
    }
    $scope.toBioskopiLista = function() {
        $state.go("bioskopiLista");
    }
    $scope.toPrijateljiLista = function() {
        $state.go("prijateljiLista");
    }
    $scope.toFanzona = function() {
        $state.go("fanzona");
    }
    $scope.toNoviOglas = function() {
        $state.go("noviOglas");
    }
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    $http.get('/api/rekvizit/svi').success(function (data) {
        $scope.rekviziti = data;
        $scope.oficialni=[];
        $scope.neoficialni=[];
        $scope.rekviziti.forEach(function (value) {
            if(value.oficijalni==true)
                $scope.oficialni.push(value);
            else
                $scope.neoficialni.push(value);
        })
    });
}]);