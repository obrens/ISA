delete from karta;
delete from projekcija;
delete from delo;
delete from sala;
delete from ustanova;
delete from projekcija;
delete from delo;
delete from ustanova;
delete from korisnik;
delete from tip_korisnika;

insert into tip_korisnika (tipkorisnika_id , naziv) values (1, 'Administrator sistema');
insert into tip_korisnika (tipkorisnika_id , naziv) values (2, 'Registrovani korisnik');
insert into tip_korisnika (tipkorisnika_id , naziv) values (3, 'Administrator ustanove');
insert into tip_korisnika (tipkorisnika_id , naziv) values (4, 'Administrator Fan zone');
insert into tip_korisnika (tipkorisnika_id , naziv) values (5, 'Posetilac');

insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (1,233233,'Novi Sad','Pera','pera@gmail.com','peron','Peric',1);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (2,123123,'Novi Sad','Jovan','jovan@gmail.com','vagon','Jovanovic',2);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (3,0645523881,'Novi Sad','Boris','boris@gmail.com','pruga','Mandic',2);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (4,4545821,'Beograd','Milan','milan@gmail.com','miki93','Milic',3);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (5,825528,'Cacak','Stevo','stevo@gmail.com','pista','Kovac',4);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (6,6184688,'Novi Sad','Lazar','lazar@gmail.com','peron','Skoric',5);
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime,uloga_tipKorisnika_id) values (7,2434525,'Novi Sad','Mitar','mitar@gmail.com','peron','Mrkic',5);

insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (1,'Gogoljeva 12','Decije pozoriste','Za decu',false,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (2,'Topolska 18','SNP','Srpsko narodno',false,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (3,'Tolstojeva 24','Arena','BA',true,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (4,'Temerinska 12','Jadran','Ovaj ne radi',true,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (5,'Hadziruvimova 80','Cineplex','U Promenadi',true,1);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (6,'Cara Dusana 18','Vojno pozoriste','Vojnici glume ovde',false,1);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (7,'Misurinova 31','Obnovljeno pozoriste','Obnovljeno-ponovo radi',false,1);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (8,'Gogoljeva 33','Cinema city','Festivalski biskop',true,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (9,'Janka Cmelika 1','Cineland','Najnoviji bioskop',true,2);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (10,'Cara Dusana 80','Platno','Najpovoljniji bioskop',true,3);
insert into ustanova (ustanova_id,adresa,naziv,opis,vrsta_ustanove,korisnik_id) values (11,'Sekspirova 42','Makos','Deciji bioskop',true,3);

insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (1,300,'Ana Karenjina','Po ruskom romanu','Marko Guduric',180,'drama',2);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (2,250,'Tri praseta','Predstava za decu','Branko Kockica',50,'komedija',1);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (3,250,'Krcko Orascic','Stiska orahe','Vadim Zakutsky',150,'misterija',2);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (4,250,'Labudovo jezero','Plivajte sa ruznim apacetom','Danijel Kosovic',120,'balet',2);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (5,1000,'Bicemo prvaci sveta','O fudbalu-jako je dobro','Bjelogrlic',80,'komedija',8);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (6,1000,'Bili smo prvaci sveta','O kosarci-bilo nam je dobro','Rados Bajic',100,'triler',9);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (7,1000,'Montevideo 3','Bikovic u glavnoj ulozi','Sin Radosa Bajica',100,'ljubavna drama',5);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (8,350,'Montevideo 7','Stanojev pubertet','Cerka Radosa Bajica',100,'krimi drama',8);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (9,300,'Selo gori, a baba se ceslja','Remek delo Radosa Bajica','Opet Rados',100,'komedija',9);
insert into delo (delo_id,cena,naziv,opis,reditelj,trajanje,zanr,ustanova_id) values (10,200,'Neunistivi','Film po romanu Rambo 2','Radosev brat',110,'triler',5);

insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (1,10,10,'A1',3);
insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (2,9,9,'A2',3);
insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (3,8,10,'B1',3);
insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (4,6,9,'C1',3);
insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (5,8,8,'Sala 1',5);
insert into sala (sala_id,broj_kolona,broj_redova,naziv_sale,ustanova_id) values (6,10,9,'Sala 1',5);

insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (1, 350, '20180620','20:00',5,1);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (2, 250, '20180620','12:00',6,2);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (3, 250, '20180620','18:00',5,3);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (4, 350, '20180620','16:00',5,4);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (5, 200, '20180621','20:00',7,5);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (6, 200, '20180621','18:00',8,6);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (7, 250, '20180621','16:00',7,6);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (8, 200, '20180621','12:00',8,5);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (9, 300, '20180622','20:00',9,1);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (10, 150, '20180622','18:00',10,2);

insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (1,true,1,1,1,2);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (2,true,1,1,2,2);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (3,true,1,1,3,2);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (4,true,1,1,4,2);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (5,true,1,1,5,5);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (6,true,1,1,6,5);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (7,true,2,1,1,3);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (8,true,2,1,2,3);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (9,true,2,1,3,3);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (10,true,2,1,4,3);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (11,true,2,2,1,6);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (12,true,2,2,2,6);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (13,true,3,1,2,7);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (14,true,3,2,4,5);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id) values (15,true,3,3,2,2);