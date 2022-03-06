package rs.ac.uns.ftn.svtvezbe06oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.svtvezbe06oauth.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
