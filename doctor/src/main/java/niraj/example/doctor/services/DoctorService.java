package niraj.example.doctor.services;


import niraj.example.doctor.feign.doctorinterface;
import niraj.example.doctor.models.AppointmentDtos.AppointmentResponse;
import niraj.example.doctor.models.DoctorDtos.Doctor;
import niraj.example.doctor.models.DoctorDtos.DoctorRequest;
import niraj.example.doctor.models.DoctorDtos.DoctorResponse;
import niraj.example.doctor.repo.DoctorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;
    private final doctorinterface docif;
    DoctorService(DoctorRepo doctorRepo, doctorinterface docif){
        this.doctorRepo = doctorRepo;
        this.docif = docif;
    }

    public DoctorResponse addDoctor(DoctorRequest doctorRequest) {

        Doctor newDoctor = new Doctor();

        newDoctor.setName(doctorRequest.getName());
        newDoctor.setSpecialization(doctorRequest.getSpecialization());
        newDoctor.setEmail(doctorRequest.getEmail());

        Doctor savedDoctor = doctorRepo.save(newDoctor);

        return new DoctorResponse(
                savedDoctor.getId(),
                savedDoctor.getName(),
                savedDoctor.getSpecialization(),
                savedDoctor.getEmail(),
                savedDoctor.getCreatedAt()
        );

    }

    public List<DoctorResponse> GetAllDoctor() {

        List<Doctor> list = doctorRepo.findAll();
        List<DoctorResponse>  allDoc = new ArrayList<>();

        for(Doctor d: list){
            DoctorResponse Doc = new DoctorResponse(
                   d.getId(),
                   d.getName(),
                   d.getSpecialization(),
                   d.getEmail(),
                   d.getCreatedAt()
            );
            allDoc.add(Doc);
        }
        return allDoc;
    }

    public DoctorResponse GetDoctorById(Long id) {

        Doctor doc = doctorRepo.findById(id).orElseThrow();
        return new DoctorResponse(
                doc.getId(),
                doc.getName(),
                doc.getSpecialization(),
                doc.getEmail(),
                doc.getCreatedAt()
        );

    }

    public DoctorResponse UpdateDoctor(Long id, DoctorRequest Request) {
        Doctor doc = doctorRepo.findById(id).orElseThrow();
        doc.setEmail(Request.getEmail());
        doc.setSpecialization(Request.getSpecialization());
        doc.setName(Request.getName());

        Doctor d =  doctorRepo.save(doc);
        return new DoctorResponse(
                d.getId(),
                d.getName(),
                d.getSpecialization(),
                d.getEmail(),
                d.getCreatedAt()
        );
    }

    public DoctorResponse DeleteDoctor(Long id) {
        Doctor toBeDeletedDoctor = doctorRepo.findById(id).orElseThrow();
        DoctorResponse doc = new DoctorResponse(
                toBeDeletedDoctor.getId(),
                toBeDeletedDoctor.getName(),
                toBeDeletedDoctor.getSpecialization(),
                toBeDeletedDoctor.getEmail(),
                toBeDeletedDoctor.getCreatedAt()
        );
        doctorRepo.deleteById(id);
        return doc;
    }


    public List<AppointmentResponse> showAppoimentforDoctor( String name){
        List<AppointmentResponse> list =  docif.showAppoimentforDoctor(name);
        return list;
    }


    public String getDoctorName(String name) {
         Doctor d = doctorRepo.findBySpecialization(name);
         return d.getName();
    }
}
