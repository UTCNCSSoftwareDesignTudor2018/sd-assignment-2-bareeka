package com.sd.assignment2.service;

import com.sd.assignment2.persistence.entity.Teacher;
import com.sd.assignment2.persistence.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    public Teacher update (Teacher t){
        return teacherRepo.save(t);
    }

    public Teacher findById(Integer id){
        return teacherRepo.getOne(id);
    }

    public List<Teacher> findAll(){
        return teacherRepo.findAll();
    }
}
