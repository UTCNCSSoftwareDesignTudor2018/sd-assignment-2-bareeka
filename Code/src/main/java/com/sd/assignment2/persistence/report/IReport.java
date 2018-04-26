package com.sd.assignment2.persistence.report;

import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.persistence.entity.Teacher;

import java.net.UnknownHostException;
import java.util.List;

public interface IReport<T> {
    void saveReport(Teacher teacher, String name, List<T> list) throws UnknownHostException;
}
