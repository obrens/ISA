var ustanoveApp= angular.module('ustanoveApp',['ui.router','ngMaterial', 'jkAngularRatingStars'])

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
        .state('prijateljiLista',{
            url:'/prijateljiLista',
            controller: 'prijateljiListaController',
            templateUrl:'poluPages/prijateljiLista.html'

        })
        .state('userProfil',{
            url:'/userProfil',
            controller: 'userProfilController',
            templateUrl:'poluPages/userProfil.html'

        })
        .state('pocetnaNeprijavljeni',{
            url:'/pocetnaNeprijavljeni',
            controller: 'pocetnaNeprijavljeniController',
            templateUrl: 'poluPages/pocetnaNeprijavljeni.html'
        })
        .state('ustanova',{
            url:'/ustanova/:id',
            controller: 'ustanovaController',
            templateUrl: 'poluPages/ustanova.html'
        })
        .state('fanzona',{
            url:'/fanzona',
            controller: 'fanzonaController',
            templateUrl: 'poluPages/rekviziti.html'
        })
        .state('oglasi',{
            url:'/oglasi',
            controller: 'oglasiController',
            templateUrl: 'poluPages/oglasi.html'
        })
        .state('pregledPonudaOglasa',{
            url:'/pregledPonuda/:id',
            controller: 'pregledPonudaOglasaController',
            templateUrl: 'poluPages/pregledPonudaOglasa.html'
        })
        .state('azuriranjeProfila',{
            url:'/azuriranje',
            controller: 'azuriranjeProfilaController',
            templateUrl: 'poluPages/azuriranjeProfila.html'
        })
        .state('noviOglas',{
            url:'/noviOglas',
            controller: 'noviOglasController',
            templateUrl: 'poluPages/noviOglas.html'
        })
        .state('ustanovaIzmena',{
            url:'/ustanovaIzmena/:id',
            controller: 'ustanovaIzmenaController',
            templateUrl: 'poluPages/ustanovaIzmena.html'
        })
        .state('brzaRezervacija',{
            url:'/brzaRezervacija/:idUstanove',
            controller: 'brzaRezervacijaController',
            templateUrl: 'poluPages/brzaRezervacija.html'
        })
        .state('karteNaPopustuIzmena',{
            url:'/karteNaPopustuIzmena/:idUstanove',
            controller: 'karteNaPopustuIzmenaController',
            templateUrl: 'poluPages/karteNaPopustuIzmena.html'
        })

}])