package edu.miu.cs.cs425.studentmgmt.service.studentserviceimpl;

import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.repository.CourseRepository;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Course createNewCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }
}
