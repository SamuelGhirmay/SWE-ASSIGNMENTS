package edu.miu.cs.cs425.student.controller;

import edu.miu.cs.cs425.student.dto.StudentRequest;
import edu.miu.cs.cs425.student.exception.StudentNotFoundException;
import edu.miu.cs.cs425.student.model.Student;
import edu.miu.cs.cs425.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/secured/student/restapi"})
public class StudentRestController {
    @Autowired
    private StudentService studentService;
    @GetMapping(value = "/list")     //ResponseRquest helps us in handling an exception
    public ResponseEntity<List<Student>> listOfStudent(){

        return ResponseEntity.ok(studentService.getAllStudent());
    }
    @GetMapping(value = "/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }
    @PostMapping(value = {"/new"})
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest){

        return new ResponseEntity<>(studentService.addNewStudent(studentRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest,@PathVariable Long studentId) throws StudentNotFoundException {
        return new ResponseEntity<>(studentService.updateStudent(studentRequest,studentId),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{studentId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = {"/search/{nameStart}"})
    public ResponseEntity<List<Student>> searchStudentByName(@PathVariable String nameStart){
        return ResponseEntity.ok(studentService.findStudentByName(nameStart));
    }
}
