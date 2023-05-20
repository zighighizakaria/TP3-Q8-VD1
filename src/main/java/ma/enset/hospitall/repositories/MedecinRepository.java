package ma.enset.hospitall.repositories;

import ma.enset.hospitall.entities.Medecin;
import ma.enset.hospitall.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
