package rs.ac.uns.ftn.svtvezbe07.service;

import rs.ac.uns.ftn.svtvezbe07.model.entity.Club;

import java.util.List;
import java.util.Optional;

public interface ClubService {

    List<Club> getAll();
    Optional<Club> getById(Long id);
    Club save(Club club);
}
