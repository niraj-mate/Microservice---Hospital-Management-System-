package niraj.example.patient.models.Patientsdtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String bloodGroup;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
//{
//        "firstName": "Aditiya",
//        "lastName": "dhar",
//        "gender": "M",
//        "birthDate": "2000-05-10",
//        "email": "AdityaDhar@gmail.com",
//        "bloodGroup": "A+ve"
//        }
