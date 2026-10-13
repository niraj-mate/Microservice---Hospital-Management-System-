package niraj.example.patient.feign;

import niraj.example.patient.models.AppointmentDtos.AppointmentRequest;
import niraj.example.patient.models.AppointmentDtos.AppointmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("APPOIMENT-SERVICE")
public interface QuizInterface {

    @PostMapping("/Appointment/book")
    public String bookAppoiment(@RequestBody AppointmentRequest appointmentRequest);

    @GetMapping("/Appointment/getBy/{name}")
    public List<AppointmentResponse> showAppoimentforPatient(@PathVariable String name);


}
