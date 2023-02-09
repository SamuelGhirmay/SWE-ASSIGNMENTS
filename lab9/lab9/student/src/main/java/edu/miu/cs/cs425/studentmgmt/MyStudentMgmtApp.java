package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassRoomService;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
    @Autowired
    StudentService studentService;
    @Autowired
    TranscriptService transcriptService;
    @Autowired
    ClassRoomService classRoomService;
    @Autowired
    CourseService courseService;
    public static void main(String[] args) {

        SpringApplication.run(MyStudentMgmtApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Student App");
//Adding Student
        Student anna=new Student(null,"000-61-0001","Anna","Lynn","Smith",3.45, LocalDate.of(2019,05,24));
        var saveAnna=saveNewStudent(anna);


//Adding Transcript

      Transcript samTranscript=new Transcript(1,"BS Computer Science");
       var savesamTranscript=saveNewTranscript(samTranscript); //Persisting data to database
        saveAnna.setTranscript(savesamTranscript);               // setting the Student data
        var updatedAnna = studentService.updateStudent(saveAnna);
        System.out.println(updatedAnna);

//Adding ClassRoom

        ClassRoom mcLaughlin= new ClassRoom(1,"McLaughlin building","M105");
        var saveMcLaughlin=saveNewClassRoom(mcLaughlin);
        saveAnna.setClassRoom(saveMcLaughlin);
        var updateAnna=studentService.updateStudent(saveAnna);
        System.out.println(updateAnna);

//Course

        Course swe= new Course(null,"SWE","cs425");
        var saveCourses=saveNewCourse(swe);
        List<Course> courses = new ArrayList<>();
        courses.add(saveCourses);
        saveAnna.setCourses(courses);



        System.out.println("Student saved in Database");
    }

//Creating Student
    private Student saveNewStudent(Student newStudent){
    return studentService.createNewStudent(newStudent);
    }

//Creating Transcript
    private Transcript saveNewTranscript(Transcript newTranscritp){return transcriptService.createNewTranscript(newTranscritp);
    }
//creating Classroom
    private ClassRoom saveNewClassRoom(ClassRoom newClassRoom){return classRoomService.createNewClassRoom(newClassRoom);
    }
//Creating Course
    private Course saveNewCourse(Course newCourse){
        return courseService.createNewCourse(newCourse);
    }

}