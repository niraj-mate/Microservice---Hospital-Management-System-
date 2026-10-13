package niraj.example.patient.controllers;




import niraj.example.patient.models.AppointmentDtos.AppointmentRequest;
import niraj.example.patient.models.AppointmentDtos.AppointmentResponse;
import niraj.example.patient.models.Patientsdtos.PatientRequest;
import niraj.example.patient.models.Patientsdtos.PatientResponse;
import niraj.example.patient.services.PatientsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patient")
public class PatientsController {


    private final PatientsService patientsService;


    public PatientsController( PatientsService patientsService) {

        this.patientsService = patientsService;
    }


    @GetMapping("/getAll")
    public List<PatientResponse> getAllPatients(){
        return patientsService.getAllPatients();
    }

    @GetMapping("/getByID/{id}")
    public PatientResponse getPatientByID(@PathVariable Long id){
        return patientsService.getPatientByID(id);
    }

    @DeleteMapping("/{id}")
    public PatientResponse DeletePatient(@PathVariable Long id){
        return patientsService.DeletePatient(id);
    }

    @PutMapping("/{id}")
    public PatientResponse updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest){
        return patientsService.updatePatient(id,patientRequest );
    }

    @PostMapping("/add")  // client > pass Dtos thorugh Ctrller > Service get Dtos, passes to model, then passes to repo
    public PatientResponse addPatient(@RequestBody PatientRequest patientRequest){
        return patientsService.addPatient(patientRequest);
    }
    ////////////////////////////////////////////////////////////////////////
    @PostMapping("/book")
    public String bookAppoiment(@RequestBody AppointmentRequest appointmentRequest){
        return patientsService.BookAppoiment(appointmentRequest);

    }
    @GetMapping("/getBy/{name}")
    public List<AppointmentResponse> showAppoimentforPatient(@PathVariable String name){
        return patientsService.showAppoimentforPatient(name);
    }


}
