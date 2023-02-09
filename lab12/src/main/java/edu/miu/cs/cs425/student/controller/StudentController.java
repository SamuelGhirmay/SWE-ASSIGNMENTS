package edu.miu.cs.cs425.student.controller;

import edu.miu.cs.cs425.student.model.Student;
import edu.miu.cs.cs425.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/","/secured/student"})
public class StudentController {
    @Autowired
    StudentService studentService;


// Home Page

    @GetMapping(value = {"/home","/"})
    public String displayHome(){
        return "public/index";
    }



//Dispalying The Lists

    @GetMapping(value = "/list")
    public ModelAndView displayListOfStudent(){
        var modelAndView=new ModelAndView();
        var student=studentService.getAllStudent();
        modelAndView.addObject("fetchedStudent",student);
        modelAndView.setViewName("secured/student/list");
        return modelAndView;
    }


//Adding New Student


    @GetMapping(value={"/new"})
    public String displayAddingPage(Model model){
        model.addAttribute("student",new Student());
        return "secured/student/new";
    }
    @PostMapping(value={"/new"})
    public String addStudent(@Valid @ModelAttribute("student")Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            model.addAttribute("student",student);
            model.addAttribute("error",result.getAllErrors());
            return "secured/student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/secured/student/list";
    }

    //Delete

        @GetMapping(value = {"/list/delete/{studentId}"})
    public String deletePublisher(@PathVariable Long studentId) {
            studentService.deleteStudent(studentId);
        return "redirect:/secured/student/list";
    }

    //Editing

    @GetMapping(value = {"/list/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "secured/student/update";
        }
        return "redirect:/secured/student/list";
    }

        @PostMapping(value = {"/update/{studentId}"})
    public String updateStudent(@Valid @ModelAttribute("studentId") Student student,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/student/update";
        }
       var studentSaved= studentService.updateStudent(student);
            System.out.println(studentSaved);
        return "redirect:/secured/student/list";
    }

    @GetMapping(value = {"/searchview"})
    public String displaySearch(){
        return "secured/searched/search";
    }


    @GetMapping(value = {"/search"})
    public ModelAndView searchStudent(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var student = studentService.findStudentByName(searchString);
        modelAndView.addObject("student", student);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("secured/searched/search");
        return modelAndView;
    }
}
