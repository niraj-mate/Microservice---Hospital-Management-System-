package niraj.example.appointment.controllers;


import niraj.example.appointment.models.AppointmentDtos.AppointmentRequest;
import niraj.example.appointment.models.AppointmentDtos.AppointmentResponse;
import niraj.example.appointment.models.AppointmentDtos.Appointments;
import niraj.example.appointment.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {


    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public AppointmentResponse getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/all")
    public List<AppointmentResponse> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @DeleteMapping("/{id}")
    public AppointmentResponse deleteAppointment(@PathVariable Long id){
        return appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public AppointmentResponse updateAppointment(@PathVariable Long id, @RequestBody AppointmentRequest request){
        return appointmentService.updateAppointment(id,request );
    }

    @PostMapping("/add")
    public  AppointmentResponse addAppointment(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.addAppointment(appointmentRequest);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/book")
    public String bookAppoiment(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.BookAppoiment(appointmentRequest);

    }
    @GetMapping("/getBy/{name}")
    public List<AppointmentResponse> showAppoimentforPatient(@PathVariable String name){
        return appointmentService.showAppoimentforPatient(name);
    }
    @GetMapping("/getByName/{name}")
    public List<AppointmentResponse> showAppoimentforDoctor(@PathVariable String name){
        return appointmentService.showAppoimentforDoctor(name);
    }

    @GetMapping("/reason/{name}")
    public String getDoctorName(@PathVariable String name){
        return appointmentService.getDoctorName(name);

    }




}
