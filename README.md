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
