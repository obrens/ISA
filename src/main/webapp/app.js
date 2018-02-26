'use-strict';

var apka = angular.module('apka', ['ui.router',  'angular-input-stars']);

iceipiceApp.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

    $urlRouterProvider.otherwise('/index');
    $stateProvider
        .state('index', {
            url: '/index',
            controller: 'indexController',
            templateUrl: 'page/index.html',
            data: {
                pageTitle: 'Početna'
            }
        });
/*
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';*/
}).run(function ($rootScope, $location, authorizationService) {

    // var publicRoutes = ['/signIn', '/register'];
    //
    // var isPublicRoute = function (route) {
    //     for(var i in publicRoutes) {
    //         if (publicRoutes[i] === route) {
    //             return true;
    //         }
    //     }
    //     return false;
    // };
    //
    // $rootScope.$on('$stateChangeStart', function (ev, to, toParams, from, fromParams) {
    //     if (isPublicRoute($location.path())) {
    //         return;
    //     }
    //     if (!isPublicRoute($location.path()) && !authorizationService.getUser()) {
    //         $location.path('/signIn');
    //     }
    // });
});