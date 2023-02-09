package edu.miu.cs.cs425.student.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {

    private Long studentId;
   // @NotBlank(message = "StudnetNumber cannot be blank or empty or null")
    private String studentNumber;
   // @NotBlank(message = "Studnet name cannot be blank or empty or null")
    private String firstName;

    private String middleName;

    private String lastName;

    private Double cgpa;

    private LocalDate dateOfEnrollment;

    private Boolean isInternational;
}
