var apka = angular.module('apka', []);

apka.controller('kontro', function($scope, $http) {
    $scope.submit = function () {
        $http.get('/usa').success(function (data) {
            console.log('Uspesno dodat ponuđač.');
            $scope.inme=data.naziv;
            $scope.cancel();
        }).error(function () {
            alert('Greška pri dodavanju ponuđača.');
        });
    };
});


