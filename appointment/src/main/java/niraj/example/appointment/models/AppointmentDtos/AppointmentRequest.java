package niraj.example.appointment.models.AppointmentDtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AppointmentRequest {

    private String reason;
    private String status;
    private  String patientName;
}
//{
//        "reason": "stomach",
//        "status": "ok",
//        "patientName": "ronn",
//        }
