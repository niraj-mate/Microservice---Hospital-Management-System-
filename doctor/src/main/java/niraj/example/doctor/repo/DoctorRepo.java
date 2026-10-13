package niraj.example.doctor.repo;


import niraj.example.doctor.models.DoctorDtos.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {



    Doctor findBySpecialization(String reason);
}
