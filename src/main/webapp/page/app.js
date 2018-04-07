'use-strict';

/*var ustanoveApp = angular.module('ustanoveApp', ['ui.router',  'angular-input-stars']);

ustanoveApp.controller('kontro', function($scope, $http) {
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

ustanoveApp.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

    $urlRouterProvider.otherwise('/login');
    $stateProvider
        .state('login', {
            url: '/login',
            controller: 'loginController',
            templateUrl: 'login.html',
            data: {
                pageTitle: 'Prijava'
            }
        })
        .state('register', {
            url: '/register',
            controller: 'registerController',
            templateUrl: 'register.html',
            data: {
                pageTitle: 'Registracija'
            }
        })
        .state('userProfil', {
            url: '/userProfil',
            controller: 'userProfileController',
            templateUrl: 'userProfil.html',
            data: {
                pageTitle: 'Moj profil'
            }
        })

    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
}).run(function ($rootScope, $location, authorizationService) {
    //nesto
});

/*var apka = angular.module('apka', []); -----------ono nase staro greota brisati

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
*/

