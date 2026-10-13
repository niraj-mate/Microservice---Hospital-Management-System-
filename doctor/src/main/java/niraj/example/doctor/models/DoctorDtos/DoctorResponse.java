package niraj.example.doctor.models.DoctorDtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DoctorResponse {

    private Long id;
    private  String name;
    private  String specialization;
    private String email;
    private LocalDateTime createdAt;
}
