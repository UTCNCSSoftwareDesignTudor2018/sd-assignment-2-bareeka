package com.sd.assignment2.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentid;

    @Column(columnDefinition = "CHAR(50)")
    private String name;

    @Column(columnDefinition = "CHAR(50)")
    private String address;

    @Column(columnDefinition = "CHAR(5)")
    private String groupp;

    @Column(columnDefinition = "CHAR(13)")
    private String cnp;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return groupp;
    }

    public void setGroup(String groupp) {
        this.groupp = groupp;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
