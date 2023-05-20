package ma.enset.hospitall.repositories;

import ma.enset.hospitall.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String name);
}
