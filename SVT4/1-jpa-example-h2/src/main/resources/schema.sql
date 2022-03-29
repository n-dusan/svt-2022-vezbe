CREATE TABLE gorivo
(
    gorivo_id  INT         NOT NULL AUTO_INCREMENT,
    gorivo_tip VARCHAR(30) NOT NULL,
    PRIMARY KEY (gorivo_id)
);

CREATE TABLE menjac
(
    menjac_id  INT         NOT NULL AUTO_INCREMENT,
    menjac_tip VARCHAR(30) NOT NULL,
    PRIMARY KEY (menjac_id)
);

CREATE TABLE vozilo
(
    vozilo_id                 INT         NOT NULL AUTO_INCREMENT,
    menjac_id                 INT         NOT NULL,
    gorivo_id                 INT         NOT NULL,
    vozilo_naziv              VARCHAR(30) NOT NULL,
    vozilo_predjeni_put       BIGINT,
    vozilo_snaga              INT         NOT NULL,
    vozilo_godina_proizvodnje INT,
    vozilo_cena               BIGINT,
    vozilo_datum_postavljanja DATE        NOT NULL,
    vozilo_ima_klima_uredjaj  TINYINT(1)  NOT NULL,
    vozilo_radna_zapremina    INT,
    vozilo_broj_brzina        INT         NOT NULL,
    vozilo_broj_vrata         INT         NOT NULL,
    vozilo_broj_sedista       INT         NOT NULL,
    vozilo_masa               INT,
    PRIMARY KEY (vozilo_id)
);

ALTER TABLE vozilo
    ADD CONSTRAINT fk_ide_na_gorivo FOREIGN KEY (gorivo_id)
        REFERENCES gorivo (gorivo_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE vozilo
    ADD CONSTRAINT fk_ima_menjac FOREIGN KEY (menjac_id)
        REFERENCES menjac (menjac_id) ON DELETE CASCADE ON UPDATE CASCADE;