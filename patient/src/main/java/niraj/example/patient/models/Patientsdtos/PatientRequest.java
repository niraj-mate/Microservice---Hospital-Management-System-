package niraj.example.patient.models.Patientsdtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {

    public String firstName;
    public String lastName;
    public String gender;
    public LocalDate birthDate;
    public String email;
    public String bloodGroup;
}
