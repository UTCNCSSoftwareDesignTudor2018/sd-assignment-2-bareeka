package com.sd.assignment2.persistence.report;

public class ReportDAOFactory {

    //singleton pattern
    private static ReportDAOFactory instance = new ReportDAOFactory();

    private ReportDAOFactory(){

    }

    public static ReportDAOFactory getInstance(){
        return instance;
    }

    public IReport getReport(String reportType) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("enrollmentReport")) {
            return new ReportDAO();
        }


        // More cases as more report types are needed

        return null;
    }
}
