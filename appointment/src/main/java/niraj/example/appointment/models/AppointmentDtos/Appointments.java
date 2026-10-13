package niraj.example.appointment.models.AppointmentDtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private String doctorName;
    private String reason;
    private String status;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime appointmentTime;
}
//        "reason": "Skin issue",
//        "status": "waiting",
