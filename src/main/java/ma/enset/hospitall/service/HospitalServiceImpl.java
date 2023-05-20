package ma.enset.hospitall.service;

import jakarta.transaction.Transactional;
import ma.enset.hospitall.entities.Consultation;
import ma.enset.hospitall.entities.Medecin;
import ma.enset.hospitall.entities.Patient;
import ma.enset.hospitall.entities.RendezVous;
import ma.enset.hospitall.repositories.ConsultationRepository;
import ma.enset.hospitall.repositories.MedecinRepository;
import ma.enset.hospitall.repositories.PatientRepository;
import ma.enset.hospitall.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
