package niraj.example.appointment.repo;


import niraj.example.appointment.models.AppointmentDtos.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointments, Long> {

    List<Appointments> findAllByDoctorName(String d);

    List<Appointments> findAllByPatientName(String p);
}
