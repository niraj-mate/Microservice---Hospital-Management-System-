package niraj.example.doctor.feign;

import niraj.example.doctor.models.AppointmentDtos.AppointmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("APPOIMENT-SERVICE")
public interface doctorinterface {
    @GetMapping("/Appointment/getByName/{name}")
    public List<AppointmentResponse> showAppoimentforDoctor(@PathVariable String name);
}
