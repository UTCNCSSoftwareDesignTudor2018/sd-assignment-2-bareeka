package com.sd.assignment2.persistence.repository;

import com.sd.assignment2.persistence.entity.Course;
import com.sd.assignment2.persistence.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

   // public List<Enrollment> findAllByStudentStudentid(Integer id);
}
