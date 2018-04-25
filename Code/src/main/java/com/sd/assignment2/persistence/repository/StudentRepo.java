package com.sd.assignment2.persistence.repository;

import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    //public List<Enrollment> findAllByStudentid(Integer id);
}
