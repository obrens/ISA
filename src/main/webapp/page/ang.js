var ustanoveApp= angular.module('ustanoveApp',['ui.router'])

ustanoveApp.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
    $urlRouterProvider.otherwise('/login');
    $stateProvider
        .state('login',{
            url:'/login',
            controller: 'loginController',
            templateUrl:'poluPages/login.html'

        })
        .state('register',{
            url:'/register',
            controller: 'registerController',
            templateUrl:'poluPages/register.html'

        })
        .state('rezervacijaPrva',{
            url:'/rezervacijaPrva',
            controller: 'rezervacijaPrvaController',
            templateUrl:'poluPages/rezervacijaPrva.html'

        })
        .state('rezervacijaDruga',{
            url:'/rezervacijaDruga',
            controller: 'rezervacijaDrugaController',
            templateUrl:'poluPages/rezervacijaDruga.html'

        })
        .state('rezervacijaTreca',{
            url:'/rezervacijaTreca',
            controller: 'rezervacijaTrecaController',
            templateUrl:'poluPages/rezervacijaTreca.html'

        })
        .state('listaRezervacija',{
            url:'/listaRezervacija',
            controller: 'listaRezervacijaController',
            templateUrl:'poluPages/listaRezervacija.html'

        })
        .state('istorijaPoseta',{
            url:'/istorijaPoseta',
            controller: 'istorijaPosetaController',
            templateUrl:'poluPages/istorijaPoseta.html'

        })
        .state('bioskopiLista',{
            url:'/bioskopiLista',
            controller: 'bioskopiListaController',
            templateUrl:'poluPages/bioskopiLista.html'

        })
        .state('userProfil',{
            url:'/userProfil',
            controller: 'userProfilController',
            templateUrl:'poluPages/userProfil.html'

        })
}])