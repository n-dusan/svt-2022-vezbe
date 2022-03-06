package rs.ac.uns.ftn.svtvezbe04.primer02.service;

import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Vozilo;

import java.util.List;

public interface VoziloService {

    Vozilo findOne(Integer voziloId);

    List<Vozilo> findAll();

    Vozilo save(Vozilo vozilo);

    void remove(Integer id);

}
