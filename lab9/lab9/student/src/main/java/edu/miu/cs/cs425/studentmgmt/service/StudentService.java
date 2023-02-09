package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;


public interface StudentService {
    Student createNewStudent(Student newStudent);
    Student updateStudent(Student editedStudent);

}
