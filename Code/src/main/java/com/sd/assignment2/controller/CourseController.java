package com.sd.assignment2.controller;

import com.sd.assignment2.persistence.entity.Course;
import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.service.CourseService;
import com.sd.assignment2.service.EnrollmentService;
import com.sd.assignment2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    EnrollmentService enrollmentService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student{id}/enrollment",method = RequestMethod.GET)
    public ModelAndView viewCourses(@PathVariable String id)
    {
        List<Course> courseList = courseService.findAll();
        List<Enrollment> enrollmentList = enrollmentService.findAllByStudent(studentService.findById(Integer.parseInt(id)));

        ModelAndView mav = new ModelAndView("course_template");
        mav.addObject("courseList",courseList);
        mav.addObject("enrollmentList",enrollmentList);

        return mav;
    }

    @RequestMapping(value = "/student{id}/enrollment",method = RequestMethod.POST)
    public ModelAndView viewCourses(@PathVariable String id, @ModelAttribute(value="courseId") @RequestParam Integer courseId)
    {
        enrollmentService.enrollStudent(studentService.findById(Integer.parseInt(id)),courseService.getCourseById(courseId));

        return new ModelAndView("redirect:/student{id}/enrollment");
    }

}
