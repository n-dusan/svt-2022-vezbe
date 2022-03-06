package rs.ac.uns.ftn.svtvezbe04.primer02.service;

import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Gorivo;

import java.util.List;

public interface GorivoService {

    Gorivo findOne(Integer gorivoId);

    List<Gorivo> findAll();

    Gorivo save(Gorivo gorivo);

    void remove(Integer id);

}
