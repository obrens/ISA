delete from ponuda;
delete from rekvizit;
delete from karta_na_popustu;
delete from karta;
delete from projekcija;
delete from delo;
delete from sala;
delete from ustanova;
delete from projekcija;
delete from delo;
delete from ustanova;
delete from korisnik_uloge;
delete from korisnik;
delete from tip_korisnika;

insert into tip_korisnika (tipkorisnika_id , naziv) values (1, 'Administrator sistema');
insert into tip_korisnika (tipkorisnika_id , naziv) values (2, 'Registrovani korisnik');
insert into tip_korisnika (tipkorisnika_id , naziv) values (3, 'Administrator ustanove');
insert into tip_korisnika (tipkorisnika_id , naziv) values (4, 'Administrator Fan zone');

insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (1,233233,'Novi Sad','Pera','pera@gmail.com','peron','Peric');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (2,123123,'Novi Sad','Jovan','jovan@gmail.com','vagon','Jovanovic');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (3,0645523881,'Novi Sad','Boris','boris@gmail.com','pruga','Mandic');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (4,4545821,'Beograd','Milan','milan@gmail.com','miki93','Milic');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (5,825528,'Cacak','Stevo','stevo@gmail.com','pista','Kovac');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (6,6184688,'Novi Sad','Lazar','lazar@gmail.com','peron','Skoric');
insert into korisnik (korisnik_id,broj_telefona,grad,ime, imejl,lozinka,prezime) values (7,2434525,'Novi Sad','Mitar','mitar@gmail.com','peron','Mrkic');

insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (1,1);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (2,2);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (3,3);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (4,4);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (5,2);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (6,2);
insert into korisnik_uloge(korisnik_id,tipkorisnika_id) values (7,2);

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

insert into delo (delo_id,cena,naziv,opis,poster,reditelj,trajanje,zanr,ustanova_id) values (1,300,'Ana Karenjina','Po ruskom romanu',LOAD_FILE('baza.PNG'),'Marko Guduric',180,'drama',2);
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
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (11, 400, '20160622','18:00',7,6);
insert into projekcija (projekcija_id,cena,datum,vreme,delo_delo_id,sala_sala_id) values (12, 250, '20160622','21:00',2,2);

insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (1,true,1,1,1,2,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (2,true,1,1,2,2,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (3,true,1,1,3,2,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (4,true,1,1,4,2,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (5,false,1,1,5,5,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (6,false,1,1,6,5,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (7,false,2,1,1,3,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (8,false,2,1,2,3,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (9,false,2,1,3,3,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (10,false,2,1,4,3,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (11,false,2,2,1,6,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (12,false,2,2,2,6,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (13,false,3,1,2,7,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (14,false,3,2,4,5,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (15,false,3,3,2,2,false,0,false,0);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (16,true,11,4,2,2,true,5,true,4);
insert into karta (karta_id,rezervisana,projekcija_projekcija_id,red,sediste,kupac_korisnik_id,ocenjen_ambijent,ocena_ambijenta,ocenjena_projekcija,ocena_projekcije) 
values (17,true,12,7,6,2,true,3,true,4);

insert into karta_na_popustu(karta_na_popustu_id, karta_karta_id, cena, rezervisana) values (1, 1, 100, false);
insert into karta_na_popustu(karta_na_popustu_id, karta_karta_id, cena, rezervisana) values (2, 2, 150, false);
insert into karta_na_popustu(karta_na_popustu_id, karta_karta_id, cena, rezervisana) values (3, 3, 100, false);
insert into karta_na_popustu(karta_na_popustu_id, karta_karta_id, cena, rezervisana) values (4, 4, 100, false);

insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (1,'20180620','Zastavica',true,'Jako dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (2,'20180620','Sal',true,'Isto dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (3,'20180621','Naocare',true,'Bas bas dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (4,'20180621','Narukvica',true,'Ne tako dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (5,'20180622','Privezak',false,'Moze da prodje',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (6,'20180623','Lancic',false,'Jako dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (7,'20180623','Cokoladica',false,'Prilicno dobra stvar',2,true,true);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (8,'20180624','Suvenir',false,'Malo bolja stvar',2,false,false);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (9,'20180625','Poster',false,'Ne bas dobra stvar',2,false,false);
insert into rekvizit(rekvizit_id,aktivan_do,naziv,oficijalni,opis,korisnik_korisnik_id,odobren,preuzet) values (10,'20180627','Slika',false,'Bezvredna stvar',2,false,false);
	
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (1,2200,5,3);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (2,200,5,4);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (3,1000,5,5);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (4,300,6,3);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (5,860,6,4);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (6,430,6,5);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (7,350,7,3);
insert into ponuda(ponuda_id,cena,oglas_rekvizit_id,ponudjac_korisnik_id) values (8,1780,7,5);