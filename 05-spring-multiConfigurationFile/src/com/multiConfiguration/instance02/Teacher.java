package com.multiConfiguration.instance02;

public class Teacher {
    private String pname;
    private int workYears;
    private String university;
    private String department;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setWorkYears(int workYears) {
        this.workYears = workYears;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "pname='" + pname + '\'' +
                ", workYears=" + workYears +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
