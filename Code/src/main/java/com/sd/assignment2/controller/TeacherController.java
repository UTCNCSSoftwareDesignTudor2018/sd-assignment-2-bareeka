package com.sd.assignment2.controller;

import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.persistence.entity.Teacher;
import com.sd.assignment2.service.EnrollmentService;
import com.sd.assignment2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    EnrollmentService enrollmentService;

    @RequestMapping(value = "/teacher{id}", method = RequestMethod.POST)
    public ModelAndView updateTeacher(@ModelAttribute(value = "uTeacher") Teacher uTeacher , @PathVariable String id)
    {
        uTeacher.setTeacherid(Integer.parseInt(id));
        teacherService.update(uTeacher);
        return new ModelAndView("redirect:teacher{id}");

    }



    @RequestMapping(value = "/teacher{id}",method = RequestMethod.GET)
    public ModelAndView viewTeacher(@PathVariable String id)
    {
        Teacher t = teacherService.getById(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView("teacher_template");
        List<Enrollment> enrollmentList = enrollmentService.findAll();
        mav.addObject("teacher", t);
        mav.addObject("enrollmentList",enrollmentList);

        return mav;
    }

    @RequestMapping(value = "/teacher{id}/grade", method = RequestMethod.GET)
    public ModelAndView viewGrades(@PathVariable String id)
    {
       // Teacher t = teacherService.getById(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView("grade_template");
        List<Enrollment> enrollmentList = enrollmentService.findAll();
        //mav.addObject("teacher", t);
        mav.addObject("enrollmentList",enrollmentList);
        return mav;
    }

    @RequestMapping(value = "/teacher{id}/grade", method = RequestMethod.POST)
    public ModelAndView updateGrades(@ModelAttribute(value = "inGrade") Integer inGrade , @PathVariable String id, @ModelAttribute(value = "inId") Integer inId)
    {
        Enrollment e = enrollmentService.findById(inId);
        e.setGrade(inGrade);
        enrollmentService.updateEnrollment(e);
        return new ModelAndView("redirect:/teacher{id}/grade");

    }



}
