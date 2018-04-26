package com.sd.assignment2.service;

import com.sd.assignment2.persistence.entity.Course;
import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.persistence.entity.Student;
import com.sd.assignment2.persistence.entity.Teacher;
import com.sd.assignment2.persistence.report.IReport;
import com.sd.assignment2.persistence.report.Report;
import com.sd.assignment2.persistence.report.ReportDAOFactory;
import com.sd.assignment2.persistence.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepo enrollmentRepo;

    public Enrollment findById(Integer id){
        return enrollmentRepo.getOne(id);
    }

    public void enrollStudent (Student student, Course course){
        Enrollment e = new Enrollment();
        e.setCourse(course);
        e.setStudent(student);
        e.setEnrollmentDate(new Date());

        enrollmentRepo.save(e);
    }

    public List<Enrollment> findAllByStudent(Student s){
        return enrollmentRepo.findAllByStudent(s);
    }

    public List<Enrollment> findAll(){
        return enrollmentRepo.findAll();
    }

    public Enrollment updateEnrollment(Enrollment e){
        return enrollmentRepo.save(e);
    }

    public void makeReport(Teacher t, Report r, Student s){

        ReportDAOFactory rf = ReportDAOFactory.getInstance();

        IReport enrollmentDAO = rf.getReport("enrollmentReport");
        try{
            enrollmentDAO.saveReport(t,r.getName(),enrollmentRepo.findAllByStudent(s));
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

}
