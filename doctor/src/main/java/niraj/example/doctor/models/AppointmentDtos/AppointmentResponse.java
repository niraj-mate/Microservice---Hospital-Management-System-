package niraj.example.doctor.models.AppointmentDtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentResponse {

    private String patientName;
    private String doctorName;
    private String reason;
    private String status;
}
