package rs.ac.uns.ftn.svtvezbe04.primer01.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vozilo")
public class Vozilo implements Serializable {

    private static final long serialVersionUID = -4668101802825693105L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "vozilo_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "vozilo_naziv", unique = false, nullable = false)
    private String nazivVozila;

    @Column(name = "vozilo_predjeni_put", unique = false, nullable = true)
    private Long predjeniPutVozila;

    @Column(name = "vozilo_snaga", unique = false, nullable = false)
    private Integer snagaVozila;

    @Column(name = "vozilo_godina_proizvodnje", unique = false, nullable = true)
    private Integer godinaProizvodnjeVozila;

    @Column(name = "vozilo_cena", unique = false, nullable = true)
    private Integer cenaVozila;

    @Column(name = "vozilo_datum_postavljanja", unique = false, nullable = false)
    private Date datumPostavljanjaVozila;

    @Column(name = "vozilo_ima_klima_uredjaj", unique = false, nullable = false)
    private Boolean voziloImaKlimaUredjaj;

    @Column(name = "vozilo_broj_brzina", unique = false, nullable = false)
    private Integer brojBrzinaVozila;

    @Column(name = "vozilo_radna_zapremina", unique = false, nullable = true)
    private Integer radnaZapreminaVozila;

    @Column(name = "vozilo_masa", unique = false, nullable = true)
    private Integer masaVozila;

    @Column(name = "vozilo_broj_vrata", unique = false, nullable = false)
    private Integer brojVrataVozila;

    @Column(name = "vozilo_broj_sedista", unique = false, nullable = false)
    private Integer brojSedistaVozila;

    @ManyToOne
    @JoinColumn(name = "menjac_id", referencedColumnName = "menjac_id", nullable = false)
    private Menjac menjac;

    @ManyToOne
    @JoinColumn(name = "gorivo_id", referencedColumnName = "gorivo_id", nullable = false)
    private Gorivo gorivo;

    public Vozilo() {
        super();
    }

    public Vozilo(Integer brojBrzinaVozila, Integer brojSedistaVozila,
                  Integer brojVrataVozila, Integer cenaVozila,
                  Date datumPostavljanjaVozila, Integer godinaProizvodnjeVozila,
                  Gorivo gorivo, Integer masaVozila, Menjac menjac,
                  String nazivVozila, Long predjeniPutVozila,
                  Integer radnaZapreminaVozila, Integer snagaVozila,
                  Boolean voziloImaKlimaUredjaj) {
        super();
        this.brojBrzinaVozila = brojBrzinaVozila;
        this.brojSedistaVozila = brojSedistaVozila;
        this.brojVrataVozila = brojVrataVozila;
        this.cenaVozila = cenaVozila;
        this.datumPostavljanjaVozila = datumPostavljanjaVozila;
        this.godinaProizvodnjeVozila = godinaProizvodnjeVozila;
        gorivo.add(this);
        this.masaVozila = masaVozila;
        menjac.add(this);
        this.nazivVozila = nazivVozila;
        this.predjeniPutVozila = predjeniPutVozila;
        this.radnaZapreminaVozila = radnaZapreminaVozila;
        this.snagaVozila = snagaVozila;
        this.voziloImaKlimaUredjaj = voziloImaKlimaUredjaj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivVozila() {
        return nazivVozila;
    }

    public void setNazivVozila(String nazivVozila) {
        this.nazivVozila = nazivVozila;
    }

    public Long getPredjeniPutVozila() {
        return predjeniPutVozila;
    }

    public void setPredjeniPutVozila(Long predjeniPutVozila) {
        this.predjeniPutVozila = predjeniPutVozila;
    }

    public Integer getSnagaVozila() {
        return snagaVozila;
    }

    public void setSnagaVozila(Integer snagaVozila) {
        this.snagaVozila = snagaVozila;
    }

    public Integer getGodinaProizvodnjeVozila() {
        return godinaProizvodnjeVozila;
    }

    public void setGodinaProizvodnjeVozila(Integer godinaProizvodnjeVozila) {
        this.godinaProizvodnjeVozila = godinaProizvodnjeVozila;
    }

    public Integer getCenaVozila() {
        return cenaVozila;
    }

    public void setCenaVozila(Integer cenaVozila) {
        this.cenaVozila = cenaVozila;
    }

    public Date getDatumPostavljanjaVozila() {
        return datumPostavljanjaVozila;
    }

    public void setDatumPostavljanjaVozila(Date datumPostavljanjaVozila) {
        this.datumPostavljanjaVozila = datumPostavljanjaVozila;
    }

    public Boolean getVoziloImaKlimaUredjaj() {
        return voziloImaKlimaUredjaj;
    }

    public void setVoziloImaKlimaUredjaj(Boolean voziloImaKlimaUredjaj) {
        this.voziloImaKlimaUredjaj = voziloImaKlimaUredjaj;
    }

    public Integer getBrojBrzinaVozila() {
        return brojBrzinaVozila;
    }

    public void setBrojBrzinaVozila(Integer brojBrzinaVozila) {
        this.brojBrzinaVozila = brojBrzinaVozila;
    }

    public Integer getRadnaZapreminaVozila() {
        return radnaZapreminaVozila;
    }

    public void setRadnaZapreminaVozila(Integer radnaZapreminaVozila) {
        this.radnaZapreminaVozila = radnaZapreminaVozila;
    }

    public Integer getMasaVozila() {
        return masaVozila;
    }

    public void setMasaVozila(Integer masaVozila) {
        this.masaVozila = masaVozila;
    }

    public Integer getBrojVrataVozila() {
        return brojVrataVozila;
    }

    public void setBrojVrataVozila(Integer brojVrataVozila) {
        this.brojVrataVozila = brojVrataVozila;
    }

    public Integer getBrojSedistaVozila() {
        return brojSedistaVozila;
    }

    public void setBrojSedistaVozila(Integer brojSedistaVozila) {
        this.brojSedistaVozila = brojSedistaVozila;
    }

    public Menjac getMenjac() {
        return menjac;
    }

    public void setMenjac(Menjac menjac) {
        this.menjac = menjac;
    }

    public Gorivo getGorivo() {
        return gorivo;
    }

    public void setGorivo(Gorivo gorivo) {
        this.gorivo = gorivo;
    }

    public String toString() {
        return "(Vozilo)[id=" + id + ",naziv vozila=" + nazivVozila + "]";
    }

}
