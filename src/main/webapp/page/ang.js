var ustanoveApp= angular.module('ustanoveApp',['ui.router','ngMaterial', 'jkAngularRatingStars'])

ustanoveApp.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
    $urlRouterProvider.otherwise('/pocetnaNeprijavljeni');
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
            url:'/rezervacijaPrva/:id',
            controller: 'rezervacijaPrvaController',
            templateUrl:'poluPages/rezervacijaPrva.html'

        })
        .state('rezervacijaDruga',{
            url:'/rezervacijaDruga/:id',
            controller: 'rezervacijaDrugaController',
            templateUrl:'poluPages/rezervacijaDruga.html'

        })
        .state('rezervacijaTreca',{
            url:'/rezervacijaTreca/:id',
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
        .state('pozoristaLista',{
            url:'/pozoristaLista',
            controller: 'pozoristaListaController',
            templateUrl:'poluPages/pozoristaLista.html'

        })
        .state('laznaPozorista',{
            url:'/laznaPozorista',
            controller: 'laznaPozoristaController',
            templateUrl:'poluPages/laznaPozorista.html'

        })
        .state('lazniBioskopi',{
            url:'/lazniBioskopi',
            controller: 'lazniBioskopiController',
            templateUrl:'poluPages/lazniBioskopi.html'

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
        .state('ponudi',{
            url:'/ponudi/:id',
            controller: 'ponudiController',
            templateUrl: 'poluPages/ponudi.html'
        })
        .state('odobravanjeOglasa',{
            url:'/odobravanjeOglasa',
            controller: 'odobravanjeOglasaController',
            templateUrl: 'poluPages/odobravanjeOglasa.html'
        })
        .state('odobriOglas',{
            url:'/odobriOglas/:id',
            controller: 'odobriOglasController',
            templateUrl: 'poluPages/odobriOglas.html'
        })
        .state('noviRekvizit',{
            url:'/noviRekvizit',
            controller: 'noviRekvizitOglasaController',
            templateUrl: 'poluPages/noviRekvizit.html'
        })
        .state('promeniUlogu',{
            url:'/promeniUlogu',
            controller: 'promeniUloguController',
            templateUrl: 'poluPages/promeniUlogu.html'
        })
        .state('azuriranjeProfila',{
            url:'/azuriranje',
            controller: 'azuriranjeProfilaController',
            templateUrl: 'poluPages/azuriranjeProfila.html'
        })
        .state('sistemStranica',{
            url:'/sistemStranica',
            controller: 'sistemStranicaController',
            templateUrl: 'poluPages/sistemStranica.html'
        })
        .state('fanAdmin',{
            url:'/fanAdmin',
            controller: 'fanAdminController',
            templateUrl: 'poluPages/fanAdmin.html'
        })
        .state('noviOglas',{
            url:'/noviOglas',
            controller: 'noviOglasController',
            templateUrl: 'poluPages/noviOglas.html'
        })
        .state('ustanovaIzmena',{
            url:'/ustanovaIzmena',
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
        .state('projekcijeIzmena',{
            url:'/projekcijeIzmena/:idUstanove',
            controller: 'projekcijeIzmenaController',
            templateUrl: 'poluPages/projekcijeIzmena.html'
        })
        .state('novaProjekcija',{
            url:'/novaProjekcija/:id',
            controller: 'novaProjekcijaController',
            templateUrl: 'poluPages/novaProjekcija.html'
        })
        .state('sale',{
            url:'/sale/:idUstanove',
            controller: 'saleController',
            templateUrl: 'poluPages/sale.html'
        })
        .state('noviPopustPrva',{
            url:'/noviPopustPrva/:id',
            controller: 'noviPopustPrvaController',
            templateUrl:'poluPages/noviPopustPrva.html'
        })
        .state('noviPopustDruga',{
            url:'/noviPopustDruga/:id',
            controller: 'noviPopustDrugaController',
            templateUrl:'poluPages/noviPopustDruga.html'
        })
        .state('noviPopustTreca',{
            url:'/noviPopustTreca/:id',
            controller: 'noviPopustTrecaController',
            templateUrl:'poluPages/noviPopustTreca.html'
        })
        .state('registrujUstanovu',{
            url:'/registrujUstanovu',
            controller: 'registrujUstanovuController',
            templateUrl: 'poluPages/registrujUstanovu.html'
        })

}])