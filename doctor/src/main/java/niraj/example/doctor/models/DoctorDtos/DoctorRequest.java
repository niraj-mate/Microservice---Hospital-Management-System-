package niraj.example.doctor.models.DoctorDtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DoctorRequest {
    private  String name;
    private  String specialization;
    private String email;
}
