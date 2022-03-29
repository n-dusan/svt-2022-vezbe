package rs.ac.uns.ftn.svtvezbe04.primer02.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Menjac;
import rs.ac.uns.ftn.svtvezbe04.primer02.repository.MenjacRepository;
import rs.ac.uns.ftn.svtvezbe04.primer02.service.MenjacService;

import java.util.List;

@Service
public class MenjacServiceImpl implements MenjacService {

    @Autowired
    MenjacRepository menjacRepository;

    @Override
    public Menjac findOne(Integer menjacId) {
        return menjacRepository.findById(menjacId).orElse(null);
    }

    @Override
    public List<Menjac> findAll() {
        return menjacRepository.findAll();
    }

    @Override
    public Menjac save(Menjac menjac) {
        return menjacRepository.save(menjac);
    }

    @Override
    public void remove(Integer id) {
        menjacRepository.deleteById(id);
    }
}
