ustanoveApp.controller('odobravanjeOglasaController', ['$scope', '$http', '$state','$window', function ($scope, $http, $state,$window) {
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
    $scope.toOglasi = function () {
        $state.go("oglasi");
    }
    $scope.logout = function() {
        $window.location.href = '/logout';
    };
    $scope.toOdobri = function(id) {
        $state.go("odobriOglas", {id: id});
    }
    $http.get('/api/rekvizit/svi').success(function (data) {
        $scope.rekviziti = data;
        $scope.oficialni=[];
        $scope.neoficialni=[];
        $scope.rekviziti.forEach(function (value) {
            if(value.oficijalni==true)
                $scope.oficialni.push(value);
            else{
                if(value.odobren==false && value.preuzet==false)
                    $scope.neoficialni.push(value);
            }
        })
    });
    $scope.preuzmi=function (x) {
        //x.odobren=true;
        x.preuzet=true;
        $http.put('/api/rekvizit/secured/izmeni', x).success(function (data) {
            var index = $scope.neoficialni.indexOf(x);
            $scope.neoficialni.splice(index,1);
            $scope.toOdobri(x.id);
        })
    }
}]);