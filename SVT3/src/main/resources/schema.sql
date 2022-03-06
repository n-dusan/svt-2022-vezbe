CREATE TABLE nastavnici
(
    nastavnikId INTEGER     NOT NULL,
    ime         VARCHAR(25) NOT NULL,
    prezime     VARCHAR(35) NOT NULL,
    zvanje      VARCHAR(50) NOT NULL,
    PRIMARY KEY (nastavnikId)
);

CREATE TABLE predmeti
(
    predmetId INTEGER      NOT NULL,
    naziv     VARCHAR(150) NOT NULL,
    PRIMARY KEY (predmetId)
);

CREATE TABLE predaje
(
    nastavnikId INTEGER NOT NULL,
    predmetId   INTEGER NOT NULL,
    PRIMARY KEY (nastavnikId, predmetId)
);

ALTER TABLE predaje
    ADD CONSTRAINT fk_predaje_nastavnik FOREIGN KEY (nastavnikId)
        REFERENCES nastavnici (nastavnikId) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE predaje
    ADD CONSTRAINT fk_predaje_predmet FOREIGN KEY (predmetId)
        REFERENCES predmeti (predmetId) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE ALIAS helloWorld AS '
void hello(String name, String surname){
    System.out.println("Hello world from " + name + " " + surname);
}
';