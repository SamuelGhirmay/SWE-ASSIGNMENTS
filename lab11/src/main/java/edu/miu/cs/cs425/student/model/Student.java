package edu.miu.cs.cs425.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
//@AllArgsConstructor(staticName = "build")
//@NoArgsConstructor
//@Getter
//@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
   // @NotBlank//(message = "Student number cann't be blank")
    private String studentNumber;
    //@JesonIgnore or @JesonBackReference(this is the best way) it helps us in tackling the bidirectional RelationShip from geting infinite loop(circular reference)
    //@NotBlank//(message = "Student's First Name cann't be blank")
    private String firstName;
    private String middleName;
    //@NotBlank(message = "Student's LastName cann't be blank")
    private String lastName;

    private Double cgpa;
//    @NotBlank(message = "Student's Date of enrollment cann't be blank")
    private LocalDate dateOfEnrollment;

    private Boolean isInternational;

    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment,Boolean isInternational) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational=isInternational;
    }

    public Student(){}

    public static Student build(Long studnetId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment,Boolean isInternational) {
        return new Student();
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", isInternational=" + isInternational +
                '}';
    }
}
