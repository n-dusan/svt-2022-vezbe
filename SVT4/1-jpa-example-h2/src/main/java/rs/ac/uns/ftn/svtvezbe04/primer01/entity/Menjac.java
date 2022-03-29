package rs.ac.uns.ftn.svtvezbe04.primer01.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menjac")
public class Menjac implements Serializable {

    private static final long serialVersionUID = 4682488404004558986L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "menjac_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "menjac_tip", unique = false, nullable = false)
    private String tipMenjaca;

    @OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "menjac")
    private Set<Vozilo> vozila = new HashSet<Vozilo>();

    public Menjac() {
        super();
    }

    public Menjac(String tipMenjaca, Set<Vozilo> vozila) {
        super();
        this.tipMenjaca = tipMenjaca;
        this.vozila = vozila;
    }

    public void add(Vozilo v) {
        if (v.getMenjac() != null)
            v.getMenjac().getVozila().remove(v);
        v.setMenjac(this);
        vozila.add(v);
    }

    public void remove(Vozilo v) {
        v.setMenjac(null);
        vozila.remove(v);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipMenjaca() {
        return tipMenjaca;
    }

    public void setTipMenjaca(String tipMenjaca) {
        this.tipMenjaca = tipMenjaca;
    }

    public Set<Vozilo> getVozila() {
        return vozila;
    }

    public void setVozila(Set<Vozilo> vozila) {
        this.vozila = vozila;
    }

    public String toString() {
        return "(Gorivo)[id=" + id + ",tip menjaca=" + tipMenjaca;
    }

}
