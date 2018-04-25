package com.sd.assignment2.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherid;

    @Column(columnDefinition = "CHAR(50)")
    private String name;



    /*@Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", name='" + name + '\'' +
                '}';
    }
    */

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
