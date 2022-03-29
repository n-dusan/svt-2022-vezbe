package rs.ac.uns.ftn.svtvezbe04.primer02.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Vozilo;
import rs.ac.uns.ftn.svtvezbe04.primer02.repository.VoziloRepository;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.VoziloService;

import java.util.List;

@Service
public class VoziloServiceImpl implements VoziloService {

    @Autowired
    VoziloRepository voziloRepository;

    @Override
    public Vozilo findOne(Integer voziloId) {
        return voziloRepository.findById(voziloId).orElse(null);
    }

    @Override
    public List<Vozilo> findAll() {
        return voziloRepository.findAll();
    }

    @Override
    public Vozilo save(Vozilo vozilo) {
        return voziloRepository.save(vozilo);
    }

    @Override
    public void remove(Integer id) {
        voziloRepository.deleteById(id);
    }
}
