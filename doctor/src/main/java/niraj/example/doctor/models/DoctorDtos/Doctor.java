package niraj.example.doctor.models.DoctorDtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Doctor {

    /// id, name, specilizrion, email, created at

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  String specialization;
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
//{
//
//        "name": "dhar",
//        "specialization": "stomach",
//        "email": "AdityaDhar@gmail.com",
//        }