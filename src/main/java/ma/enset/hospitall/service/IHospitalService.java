package ma.enset.hospitall.service;

import ma.enset.hospitall.entities.Consultation;
import ma.enset.hospitall.entities.Medecin;
import ma.enset.hospitall.entities.Patient;
import ma.enset.hospitall.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
