# svt-2022-vezbe

### Obaveštenja

## Julski rok
Rok za poslednji commit na SVT repozitorijumu je 01.07 u 23:59:59. Svaki commit ili aktivnost nakon roka će na odbrani biti vraćena na poslednji validan commit. 

### Specifikacija projekta - FAQ

1. Da li admin moze da menja zajednicu(npr uklanja flairove, menja description itd) ili on samo suspenduje zajednicu i moze da menja moderatore?
* Potrebno je dozvoliti administratoru sve moderatorske privilegije

2. Za KT pise dodavanje, brisanje, izmena liste zajednica, da li moramo da implementiramo brisanje za zajednicu, jer nam ne treba nigde u specifikaciji, i da li onda treba da uradimo suspendovanje zajednicu u zamenu za brisanje(ali je to onda zadatak za vecu ocenu zelenom bojom)
* Misli se i na brisanje, ali u ovoj fazi dovoljno je staviti jednostavan @DeleteMapping za zajednicu. Suspendovanje se ocenjuje tek na odbrani.

3. Danas ste rekli da pri izmeni flairova u zajednici treba da proverimo da li se koristi u nekom postu. Da li je to obavezno, jer onda bih morao da prodjem kroz listu postova pa za svaki post kroz listu flairova, a mislim da nema potrebe jer samo uklonimo iz zajednice i svaki novi post nece moci da ima vise taj flair, i npr ako hocemo da izbrisemo flair, a on se koristi u postu, onda bi morali novu zajednicu da pravimo
* Morace da postoji dodatna logika za azuriranje flair-a. Ako moderator zajednice 1 izmeni naziv flair-a iz "Novost" u "Vesti", da li ce se taj flair zvati "Vesti" i u recimo zajednici 2? Tako nesto nema smisla dozvoliti. Ako hocemo da izbrisemo flair, takodje nema smisla da ga brisemo direktno iz tabele flair, jer smo time uklonili taj flair iz svih zajednica. 

4. Isto pitanje i za brisanje objave, pise da samo moderator moze da ukloni prijavljenu objavu, da li onda isto moramo da implementiramo brisanje(jer ukoliko to uradimo onda moramo i prijavu)
* Moderator moze obrisati proizvoljnu objavu bez da postoji prijava na tu objavu. Treba razmisliti kako ce to uticati na prijave koje postoje na tu objavu koju je moderator obrisao.

5. Da li se prilikom kreiranja post-a flairovi kreiraju, ili se biraju iz nekog menija?
* Moderator kreira, azurira i brise flair, a korisnik ga bira iz opadajuceg menija pri kreiranju objave.

6. Да ли А2 функционалност укључује А1? За оцену 8 не треба да се имплементирају захтеви за модератора, која би онда његова улога у апликацији била? Само би у суштини требало да се промени улога обичног корисника на модератора или још нешто?
* U zavisnosti od toga kako ste modelovali, na A2 misli se na automatsko prebacivanje korisnika iz uloge Moderator u ulogu User ili samo uklanjanje korisnika iz vezne tabele Moderator.

7. Pise za "top" sortiranje po broju upvota i downota, da li to znaci da onaj ko ima najvise reakcija ce biti na vrhu ili gde je karma najveca?
* Ona objava koja ima najveću karmu

8. Da li objave mogu da se sortiranju i unutar neke zajednice ili samo na pocetnoj stranici aplikacije?
* Trebale bi da mogu na oba mesta

9. Posto login nije za 6, da li je potrebno da brisanje postova i zajednica bude implementirano? U tom slucaju delete button bi mogao svako da pritisne.
* Pod ažuriranjem se očekuje i brisanje. Pošto nema login-a, svaki korisnik može da obriše objave i zajednice. 

10. Takodje da li je okej da imam prikaz svih postova svih komjunitija i sa strane dodavanje posta, bez da prvo udjem u neki komjuniti, vec da na glavnoj strani kliknem create post i odaberem komjuniti? Tako sam pravio za front predmet. 
* Za ocenu 6 nije bitno gde su raspoređeni podaci na frontendu, ali mora da postoji vizuelna naznaka. Recimo, ako kreirate novu objavu mora na frontendu sa početne strane postojati neki padajuci meni u kojem naznačite kojoj zajednici pripada ta objava.

11. Za ocenu 6 nije potreban login, pa onda nema smisla da pri kreiranju neko postaje moderator?
* Očekuje se da za 6 imate implementiranu logiku kreiranja moderatora

12. Da li za sliku objave i za sliku korisnika trebamo da imamo upload ili možemo samo da koristimo kao string url slike?
* Misli se na upload

13. Na početnoj stranici piše prikaz nasumičnih objava iz nasumičnih zajednica na šta se tačno misli? 
* Prikaz objava sa različitih zajednica na početnoj stranici, gde na prikazu objave postoji i link koji vodi ka toj zajednici.
