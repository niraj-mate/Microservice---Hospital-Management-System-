package niraj.example.patient.repo;


import niraj.example.patient.models.Patientsdtos.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepo extends JpaRepository<Patient,Long> {


}
