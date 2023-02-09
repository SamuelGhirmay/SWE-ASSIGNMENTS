package edu.miu.cs.cs425.student.service.serviceimpl;

import edu.miu.cs.cs425.student.dto.StudentRequest;
import edu.miu.cs.cs425.student.exception.StudentNotFoundException;
import edu.miu.cs.cs425.student.model.Student;
import edu.miu.cs.cs425.student.repository.StudentRepository;
import edu.miu.cs.cs425.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student addNewStudent(StudentRequest newStudnetRequest) {
        var newStudent= new Student(null, newStudnetRequest.getStudentNumber(),newStudnetRequest.getFirstName(),
                newStudnetRequest.getMiddleName(),newStudnetRequest.getLastName(), newStudnetRequest.getCgpa(), newStudnetRequest.getDateOfEnrollment(),newStudnetRequest.getIsInternational()
                );
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(StudentRequest updateStudentReq,Long studnetId) throws StudentNotFoundException {

        var student = getStudentById(studnetId) ;

        student.setStudentId(updateStudentReq.getStudentId());
        student.setStudentNumber(updateStudentReq.getStudentNumber());

        student.setFirstName(updateStudentReq.getFirstName());

        student.setMiddleName(updateStudentReq.getMiddleName());
        student.setLastName(updateStudentReq.getLastName());
        student.setCgpa(updateStudentReq.getCgpa());
        student.setDateOfEnrollment(updateStudentReq.getDateOfEnrollment());

        student.setInternational(updateStudentReq.getIsInternational());





//        Student updateStudent= Student.build(studnetId, updateStudentReq.getStudentNumber(), updateStudentReq.getFirstName(), updateStudentReq.getMiddleName(),
//                updateStudentReq.getLastName(), updateStudentReq.getCgpa(), updateStudentReq.getDateOfEnrollment(),updateStudentReq.getIsInternational());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException{
        return studentRepository.findById(studentId).orElseThrow(()->
                new StudentNotFoundException(String.format("Student with Id: %d is not Found",studentId)));
    }
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findStudentByName(String searchString) {
        return studentRepository.findAllByFirstNameContainingOrLastNameContaining(searchString,searchString);
    }


}
