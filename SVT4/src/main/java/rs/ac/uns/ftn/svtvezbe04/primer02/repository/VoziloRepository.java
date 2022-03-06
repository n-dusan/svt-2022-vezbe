package rs.ac.uns.ftn.svtvezbe04.primer02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.svtvezbe04.primer02.entity.Vozilo;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, Integer> {
}
