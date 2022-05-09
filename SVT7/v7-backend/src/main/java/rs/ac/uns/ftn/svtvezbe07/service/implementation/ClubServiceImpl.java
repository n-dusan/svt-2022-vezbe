package rs.ac.uns.ftn.svtvezbe07.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe07.model.entity.Club;
import rs.ac.uns.ftn.svtvezbe07.repository.ClubRepository;
import rs.ac.uns.ftn.svtvezbe07.service.ClubService;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Override
    public List<Club> getAll() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Club> getById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public Club save(Club club) {
        try{
            return clubRepository.save(club);
        }catch (IllegalArgumentException e){
            return null;
        }
    }
}
