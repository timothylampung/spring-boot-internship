package com.timothy.internship.M_identity.controller.vo;

public class EmgStudentVo {

    private long studentId;
    private String matricNumber;
    private String icNumber;
    private String course;
    private String cgpa;
    private String userId;
    private String department;

    public EmgStudentVo() {
    }

    public EmgStudentVo(long studentId, String matricNumber, String icNumber, String course, String cgpa, String userId, String department) {
        this.studentId = studentId;
        this.matricNumber = matricNumber;
        this.icNumber = icNumber;
        this.course = course;
        this.cgpa = cgpa;
        this.userId = userId;
        this.department = department;
    }


    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber) {
        this.matricNumber = matricNumber;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
