package ma.enset.hospitall.repositories;

import ma.enset.hospitall.entities.Consultation;
import ma.enset.hospitall.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
