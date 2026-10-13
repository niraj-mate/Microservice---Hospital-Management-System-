package niraj.example.doctor.controllers;


import niraj.example.doctor.models.AppointmentDtos.AppointmentResponse;
import niraj.example.doctor.models.DoctorDtos.DoctorRequest;
import niraj.example.doctor.models.DoctorDtos.DoctorResponse;
import niraj.example.doctor.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {

    private final DoctorService doctorService;

    DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;

    }

    @PostMapping ("/add")
    public DoctorResponse addDoctor(@RequestBody DoctorRequest doctorRequest){
        return doctorService.addDoctor(doctorRequest);
    }

    @GetMapping("/getAll")
    public List<DoctorResponse> GetAllDoctor(){
        return doctorService.GetAllDoctor();
    }

    @GetMapping("/{id}")
    public DoctorResponse GetDoctorById(@PathVariable Long id){
        return doctorService.GetDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public DoctorResponse DeleteDoctor(@PathVariable Long id){
        return doctorService.DeleteDoctor(id);
    }

    @PutMapping("/{id}")
    public DoctorResponse UpdateDoctor(@PathVariable Long id, @RequestBody DoctorRequest doctorRequest){
        return doctorService.UpdateDoctor(id, doctorRequest);
    }
    ////////////////////////////////////////////////////////////////////////
    //Show all appoimentsList()
    // return Appoiment_status() to patient
    @GetMapping("/getByName/{name}")
    public List<AppointmentResponse> showAppoimentforPatient(@PathVariable String name){
        return doctorService.showAppoimentforDoctor(name);
    }
    @GetMapping("/reason/{name}")
    public String getDoctorName(@PathVariable String name){
        return doctorService.getDoctorName(name);
    }

}
