ustanoveApp.controller('ustanovaController', ['$scope', '$http', '$state', '$stateParams', function ($scope, $http, $state, $stateParams) {


    $http.get('/api/ustanova/' + $stateParams.id).success(function (data) {
        $scope.ustanova = data;
        var address = $scope.ustanova.adresa;

        var map = new google.maps.Map(document.getElementById('map'), {
            mapTypeId: google.maps.MapTypeId.TERRAIN,
            zoom: 6
        });

        var geocoder = new google.maps.Geocoder();

        geocoder.geocode({
                'address': address
            },
            function(results, status) {
                if(status == google.maps.GeocoderStatus.OK) {
                    new google.maps.Marker({
                        position: results[0].geometry.location,
                        map: map
                    });
                    map.setCenter(results[0].geometry.location);
                    map.setZoom(16);
                }
                else {

                    console.log("Ne moze se pronaci lokacija");
                }
            });
    });

    $scope.toPrvaRez = function (id) {
        $state.go("rezervacijaPrva", {id: id});
    };
    $scope.toBrzaRez = function (id) {
        $state.go("brzaRezervacija", {idUstanove: id});
    };

    $scope.nekoJe = false;
    console.log("prelog");
    $http.get('/api/korisnik/secured/jaDto').success(function (data) {
        $scope.ja = data;
        $scope.nekoJe = true;
    });


}]);
