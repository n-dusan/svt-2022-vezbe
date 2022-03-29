package rs.ac.uns.ftn.svtvezbe04.primer02.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Gorivo;
import rs.ac.uns.ftn.svtvezbe04.primer02.repository.GorivoRepository;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.GorivoService;

import java.util.List;

@Service
public class GorivoServiceImpl implements GorivoService {

    @Autowired
    GorivoRepository gorivoRepository;

    @Override
    public Gorivo findOne(Integer gorivoId) {
        return gorivoRepository.findById(gorivoId).orElse(null);
    }

    @Override
    public List<Gorivo> findAll() {
        return gorivoRepository.findAll();
    }

    @Override
    public Gorivo save(Gorivo gorivo) {
        return gorivoRepository.save(gorivo);
    }

    @Override
    public void remove(Integer id) {
        gorivoRepository.deleteById(id);
    }
}
