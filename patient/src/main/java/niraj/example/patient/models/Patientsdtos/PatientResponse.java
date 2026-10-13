package niraj.example.patient.models.Patientsdtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PatientResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String bloodGroup;
    private LocalDateTime createdAt;
}
