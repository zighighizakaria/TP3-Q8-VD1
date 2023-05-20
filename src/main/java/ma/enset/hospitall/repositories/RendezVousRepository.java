package ma.enset.hospitall.repositories;

import ma.enset.hospitall.entities.Medecin;
import ma.enset.hospitall.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
