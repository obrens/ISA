ustanoveApp.controller('noviPopustPrvaController', ['$scope', '$rootScope', '$state', '$http', '$stateParams', function ($scope, $rootScope, $state, $http, $stateParams) {
    $scope.arejNaziva = [];
    $scope.arejDatuma = [];
    $scope.arejVremena = [];
    var nazivTr, datumTr, vremeTr, salaTr, idTr;
    $scope.ide = {};
    $scope.selectedList = {};
    $scope.ima = false;
    $scope.toUserProfil = function () {
        $state.go("userProfil");
    };

    $scope.arejNaziva = [];
    $scope.arejDatuma = [];
    $scope.arejVremena = [];
    $scope.arejSala = [];
    $scope.ima = false;
    $http.get('/api/projekcija/secured/projekcijeUstanove/' + $stateParams.id).success(function (data) {
        $scope.selectedList.projekcije = data;

        $scope.selectedList.projekcije.forEach(function (value) {
            if ($scope.arejNaziva.includes(value.nazivDela)) {

            } else {
                $scope.arejNaziva.push(value.nazivDela);
            }
        })
    });

    $scope.nadjiDatume = function () {
        $scope.arejDatuma = [];
        $scope.arejVremena = [];
        $scope.arejSala = [];
        $scope.ima = false;
        $scope.selectedList.projekcije.forEach(function (value) {
            if (value.nazivDela === $scope.selectedDelo) {
                if ($scope.arejDatuma.includes(value.datum)) {

                } else {
                    $scope.arejDatuma.push(value.datum);
                }
                nazivTr = $scope.selectedDelo;
            }
        })
        console.log($scope.arejDatuma);
    };
    $scope.nadjiVreme = function () {
        $scope.arejVremena = [];
        $scope.arejSala = [];
        $scope.ima = false;
        $scope.selectedList.projekcije.forEach(function (value) {
            if (value.nazivDela === nazivTr && value.datum === $scope.selectedDatum) {
                if ($scope.arejVremena.includes(value.vreme)) {

                } else {
                    $scope.arejVremena.push(value.vreme);
                }
                datumTr = $scope.selectedDatum;
            }
        })
    };
    $scope.nadjiSalu = function () {
        $scope.arejSala = [];
        $scope.ima = false;
        $scope.selectedList.projekcije.forEach(function (value) {
            if (value.nazivDela === nazivTr && value.datum === datumTr && value.vreme === $scope.selectedVreme) {
                if ($scope.arejSala.includes(value.nazivSale)) {

                } else {
                    $scope.arejSala.push(value.nazivSale);
                }
                vremeTr = $scope.selectedVreme;
            }
        })
    };
    $scope.kompletiraj = function () {
        salaTr = $scope.selectedSala;
        $scope.selectedList.projekcije.forEach(function (value) {
            if (value.nazivDela === nazivTr && value.datum === datumTr && value.vreme === vremeTr && value.nazivSale === salaTr) {
                idTr = value.id;
                $scope.ide = idTr;
                $scope.ima = true;
                $rootScope.staraCena = value.cena;
            }
        })
    };
    $scope.toRez2 = function (id) {
        $state.go("noviPopustDruga", {id: id});
    };

}]);