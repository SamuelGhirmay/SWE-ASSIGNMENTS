package edu.miu.cs.cs425.student.service;

import edu.miu.cs.cs425.student.dto.StudentRequest;
import edu.miu.cs.cs425.student.exception.StudentNotFoundException;
import edu.miu.cs.cs425.student.model.Student;

import java.util.List;

public interface StudentService {
    Student addNewStudent(StudentRequest newStudnetRequest);
    List<Student> getAllStudent();

    Student updateStudent(StudentRequest updateStudentReq,Long studnetId) throws StudentNotFoundException;

    public Student getStudentById(Long studentId) throws StudentNotFoundException;

    void deleteStudentById(Long studentId);

   List<Student> findStudentByName(String searchString);





}
