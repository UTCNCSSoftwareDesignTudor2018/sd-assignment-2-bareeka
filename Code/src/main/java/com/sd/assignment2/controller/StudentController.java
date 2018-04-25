package com.sd.assignment2.controller;

import com.sd.assignment2.persistence.entity.Student;
import com.sd.assignment2.service.EnrollmentService;
import com.sd.assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;



    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
            return studentService.addStudent(student);
    }

    @RequestMapping(value = "/student{id}", method = RequestMethod.POST)
    public ModelAndView updateStudent(@ModelAttribute(value = "uStudent") Student uStudent , @PathVariable String id)
    {
        uStudent.setStudentid(Integer.parseInt(id));
        studentService.updateStudent(uStudent);

        return new ModelAndView("redirect:student{id}");

    }

    @RequestMapping(value = "/student{id}",method = RequestMethod.GET)
    public ModelAndView viewStudent(@PathVariable String id)
    {
        Student s = studentService.findById(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView("student_template");
        mav.addObject("student", s);

        return mav;
    }


    @RequestMapping(value = "/getStudent/{id}")
    public ModelAndView getStudent(@PathVariable String id){
        //Student s = studentService.findById(1);
        ModelAndView mav = new ModelAndView("students_view");
        mav.addObject("student",studentService.findById(Integer.parseInt(id)));

        return mav;
    }










}
