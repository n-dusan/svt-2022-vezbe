package rs.ac.uns.ftn.svtvezbe04.primer02.service;

import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Menjac;

import java.util.List;

public interface MenjacService {

    Menjac findOne(Integer menjacId);

    List<Menjac> findAll();

    Menjac save(Menjac menjac);

    void remove(Integer id);

}
