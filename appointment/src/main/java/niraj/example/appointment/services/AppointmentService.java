package niraj.example.appointment.services;



import niraj.example.appointment.feign.AppointmentInterface;
import niraj.example.appointment.models.AppointmentDtos.AppointmentRequest;
import niraj.example.appointment.models.AppointmentDtos.AppointmentResponse;
import niraj.example.appointment.models.AppointmentDtos.Appointments;
import niraj.example.appointment.repo.AppointmentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepo repo;
    private final AppointmentInterface feingiff;


    public AppointmentService(AppointmentRepo appointmentRepo, AppointmentInterface feingiff){
        this.repo = appointmentRepo;
        this.feingiff = feingiff;
    }

    public AppointmentResponse addAppointment(AppointmentRequest appointmentRequest) {
        Appointments a = new Appointments();
        a.setReason(appointmentRequest.getReason());  // reason is related to Stomach, we need a stomach spelist
        a.setPatientName(appointmentRequest.getPatientName());
        a.setStatus(appointmentRequest.getStatus());
        a.setDoctorName("dsds");


        Appointments a1 = repo.save(a);
        return new AppointmentResponse(
                a1.getPatientName(),
                a1.getDoctorName(),
                a1.getReason(),
                a1.getStatus()

        );
    }
    public AppointmentResponse getAppointmentById(Long id) {
        Appointments a1;
        a1 = repo.findById(id).orElseThrow();
        return new AppointmentResponse(
                a1.getPatientName(),
                a1.getDoctorName(),
                a1.getReason(),
                a1.getStatus()
        );
    }
    public List<AppointmentResponse> getAllAppointment() {

        List<Appointments> list = repo.findAll();
        List<AppointmentResponse> app_List = new ArrayList<>();

        for(Appointments a: list){
            AppointmentResponse response = new AppointmentResponse(
                    a.getPatientName(),
                    a.getDoctorName(),
                    a.getReason(),
                    a.getStatus()
            );
            app_List.add(response);
        }
        return app_List;
    }
    public AppointmentResponse deleteAppointment(Long id) {
        Appointments a = repo.findById(id).orElseThrow();
        AppointmentResponse response = new AppointmentResponse(
                a.getPatientName(),
                a.getDoctorName(),
                a.getReason(),
                a.getStatus()
        );
        repo.deleteById(id);
        return response;
    }
    public AppointmentResponse updateAppointment(Long id,AppointmentRequest request) {
        Appointments aq = repo.findById(id).orElseThrow();
        aq.setStatus(request.getStatus());
        aq.setReason(request.getReason());
       //a.setAppointmentTime(request.getAppointmentTime());
        Appointments a = repo.save(aq);

        return new AppointmentResponse(
                a.getPatientName(),
                a.getDoctorName(),
                a.getReason(),
                a.getStatus()
        );
    }

    public  String BookAppoiment(AppointmentRequest appointmentRequest) {
        Appointments A = new Appointments();
        A.setPatientName(appointmentRequest.getPatientName());
        A.setStatus(appointmentRequest.getStatus());
        A.setReason(appointmentRequest.getReason());

        // add doctor mane
        String doctorName = feingiff.getDoctorName(appointmentRequest.getReason());
        A.setDoctorName(doctorName);

        repo.save(A);

        String qq = "Appoiment Booked with +name+ with patient ";
        return qq;

    }

    public List<AppointmentResponse> showAppoimentforDoctor(String name){
        List<Appointments> list = repo.findAllByDoctorName(name);
        List<AppointmentResponse> app_List = new ArrayList<>();

        for(Appointments a: list){
            AppointmentResponse response = new AppointmentResponse(
                    a.getPatientName(),
                    a.getDoctorName(),
                    a.getReason(),
                    a.getStatus()
            );
            app_List.add(response);
        }
        return app_List;
    }
    public List<AppointmentResponse> showAppoimentforPatient(String name){
        List<Appointments> list = repo.findAllByPatientName(name);
        List<AppointmentResponse> app_List = new ArrayList<>();

        for(Appointments a: list){
            AppointmentResponse response = new AppointmentResponse(
                    a.getPatientName(),
                    a.getDoctorName(),
                    a.getReason(),
                    a.getStatus()
            );
            app_List.add(response);
        }
        return app_List;
    }


    public String getDoctorName(String name) {
        return feingiff.getDoctorName(name);
    }
}
