package ma.enset.hospitall;

import ma.enset.hospitall.entities.*;
import ma.enset.hospitall.repositories.ConsultationRepository;
import ma.enset.hospitall.repositories.MedecinRepository;
import ma.enset.hospitall.repositories.PatientRepository;
import ma.enset.hospitall.repositories.RendezVousRepository;
import ma.enset.hospitall.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitallApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitallApplication.class, args);
    }
    @Bean
 CommandLineRunner start(
         IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository,ConsultationRepository consultationRepository
    ){
        return args -> {
            Stream.of("Mohammed", "hassan","Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaisssance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("aymane", "hanane","yassmine")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5?"cardio":"dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);

                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohammed");
            Medecin medecin=medecinRepository.findByNom("yassmine");

            RendezVous rendezVous =new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("rapport ......");
            hospitalService.saveConsultation(consultation);





        };
    }



}
