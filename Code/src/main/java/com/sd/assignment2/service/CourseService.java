package com.sd.assignment2.service;

import com.sd.assignment2.persistence.entity.Course;
import com.sd.assignment2.persistence.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public Course getCourseById(Integer id){
        return courseRepo.getOne(id);
    }

    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

}
