package com.sd.assignment2.service;

import com.sd.assignment2.persistence.entity.Course;
import com.sd.assignment2.persistence.entity.Student;
import com.sd.assignment2.persistence.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public Student addStudent(Student s){
        return studentRepo.save(s);
    }

    public Student updateStudent(Student s){
        return studentRepo.save(s);
    }

    public Student findById(Integer id){
        return studentRepo.getOne(id);
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public void deleteStudent(Student s){
        if(s.getStudentid() != null) {
            studentRepo.delete(s);
        }
        else{
            System.out.println("No such student");
        }
    }


}
