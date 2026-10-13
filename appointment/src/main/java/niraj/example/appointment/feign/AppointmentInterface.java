package niraj.example.appointment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DOCTOR-SERVICE")
public interface AppointmentInterface {

    @GetMapping("/Doctor/reason/{name}")
    public String getDoctorName(@PathVariable String name);



}
