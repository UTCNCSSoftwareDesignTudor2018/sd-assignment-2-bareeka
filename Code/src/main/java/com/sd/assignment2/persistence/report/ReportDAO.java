package com.sd.assignment2.persistence.report;

import com.mongodb.*;
import com.sd.assignment2.persistence.entity.Enrollment;
import com.sd.assignment2.persistence.entity.Student;
import com.sd.assignment2.persistence.entity.Teacher;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDAO implements IReport<Enrollment> {

    private static final String URI = "mongodb://localhost:27017/assignment2";

    public void saveReport(Teacher teacher, String reportName, List<Enrollment> enrollments) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI(URI));
        DB mongoDatabase = mongoClient.getDB("assignment2");
        DBCollection databaseCollection = mongoDatabase.getCollection("enrollmentList");
        DBObject dbObject = new BasicDBObject("reportName",reportName)
                .append("by teacher: ",teacher.getName());
        List<DBObject> dbEnrollmentObjects = new ArrayList<>();

        for(Enrollment e : enrollments){
            DBObject dbEnrollmentObject = new BasicDBObject("student name: ", e.getStudent().getName())
                    .append("address",e.getStudent().getCnp())
                    .append("cnp",e.getStudent().getCnp())
                    .append("grade",e.getGrade())
                    .append("date",e.getEnrollmentDate())
                    .append("course",e.getCourse().getName());
            dbEnrollmentObjects.add(dbEnrollmentObject);
        }
        dbObject = ((BasicDBObject)dbObject).append("enrolments",dbEnrollmentObjects);
        databaseCollection.insert(dbObject);
        mongoClient.close();
    }

}
