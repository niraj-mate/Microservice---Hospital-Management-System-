package niraj.example.patient.services;


import niraj.example.patient.feign.QuizInterface;
import niraj.example.patient.models.AppointmentDtos.AppointmentRequest;
import niraj.example.patient.models.AppointmentDtos.AppointmentResponse;

import niraj.example.patient.models.Patientsdtos.Patient;
import niraj.example.patient.models.Patientsdtos.PatientRequest;
import niraj.example.patient.models.Patientsdtos.PatientResponse;
import niraj.example.patient.repo.PatientsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.desktop.QuitEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {

    private final PatientsRepo patientsRepo;
    private final QuizInterface quizInterface;

    public PatientsService(PatientsRepo patientsRepo, QuizInterface quizInterface) {
        this.patientsRepo = patientsRepo;
        this.quizInterface = quizInterface;

    }

    // CREATE
    public PatientResponse addPatient(PatientRequest request) {

        // DTO -> Entity
        Patient patient = new Patient();

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setBirthDate(request.getBirthDate());
        patient.setEmail(request.getEmail());
        patient.setBloodGroup(request.getBloodGroup());

        // Save Entity to DB
        Patient savedPatient = patientsRepo.save(patient); // >>= patientsRepo.save(patient) >> save() → save the entity + return a reference to the entity.

        // Entity -> Response DTO
        return new PatientResponse(
                savedPatient.getId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getGender(),
                savedPatient.getBirthDate(),
                savedPatient.getEmail(),
                savedPatient.getBloodGroup(),
                savedPatient.getCreatedAt()
        );
    }
    // GET ALL
    public List<PatientResponse> getAllPatients() {

        List<Patient> patients = patientsRepo.findAll();         // patientsRepo.findAll() returns a List<Patient>.
        List<PatientResponse> patientResponses = new ArrayList<>();

        for (Patient patient : patients) {
            PatientResponse response = new PatientResponse(
                    patient.getId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getGender(),
                    patient.getBirthDate(),
                    patient.getEmail(),
                    patient.getBloodGroup(),
                    patient.getCreatedAt()
            );

            patientResponses.add(response);
        }

        return patientResponses;

    }



    // GET BY ID
    public PatientResponse getPatientByID(Long id) {

        Patient patient = patientsRepo.findById(id)  //Optional<T> findById(ID id); >> findById() > returnb a optional<>
                .orElseThrow();

        return new PatientResponse(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getBirthDate(),
                patient.getEmail(),
                patient.getBloodGroup(),
                patient.getCreatedAt()
        );
    }

    public PatientResponse DeletePatient(Long id) {

        Optional<Patient> tempPatient = patientsRepo.findById(id); // copying patient data as we need to return
        PatientResponse p = new PatientResponse(
                tempPatient.get().getId(),
                tempPatient.get().getFirstName(),
                tempPatient.get().getLastName(),
                tempPatient.get().getGender(),
                tempPatient.get().getBirthDate(),
                tempPatient.get().getEmail(),
                tempPatient.get().getBloodGroup(),
                tempPatient.get().getCreatedAt()
        );

        patientsRepo.deleteById(id); // deleted the patient form the database
        return p;

    }

    public PatientResponse updatePatient(Long id, PatientRequest request) {

        Patient oldPatient = patientsRepo.findById(id).orElseThrow();
        oldPatient.setFirstName(request.getFirstName());
        oldPatient.setLastName(request.getLastName());
        oldPatient.setGender(request.getGender());
        oldPatient.setBirthDate(request.getBirthDate());
        oldPatient.setEmail(request.getEmail());
        oldPatient.setBloodGroup(request.getBloodGroup());

        patientsRepo.save(oldPatient);


        return new PatientResponse(
                oldPatient.getId(),
                oldPatient.getFirstName(),
                oldPatient.getLastName(),
                oldPatient.getGender(),
                oldPatient.getBirthDate(),
                oldPatient.getEmail(),
                oldPatient.getBloodGroup(),
                oldPatient.getCreatedAt()
        );

    }

    public String BookAppoiment(AppointmentRequest appointmentRequest) {
        quizInterface.bookAppoiment(appointmentRequest);
        return  "Appointment booked";
    }
    public List<AppointmentResponse> showAppoimentforPatient( String name){
        List<AppointmentResponse> list =  quizInterface.showAppoimentforPatient(name);
        return list;
    }


}