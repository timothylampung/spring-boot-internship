package com.timothy.internship.M_identity.controller.vo;

public class EmgLeturerVo {


    private long lecturerId;
    private String lecturerName;
    private String lecturerDepartment;
    private String userId;
    private EmgAdminVo adminProfile;
    private EmgStudentVo studentProfile;
    private EmgLeturerVo leturerProfile;


    public EmgAdminVo getAdminProfile() {
        return adminProfile;
    }

    public void setAdminProfile(EmgAdminVo adminProfile) {
        this.adminProfile = adminProfile;
    }

    public EmgStudentVo getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(EmgStudentVo studentProfile) {
        this.studentProfile = studentProfile;
    }

    public EmgLeturerVo getLeturerProfile() {
        return leturerProfile;
    }

    public void setLeturerProfile(EmgLeturerVo leturerProfile) {
        this.leturerProfile = leturerProfile;
    }



    public EmgLeturerVo(EmgAdminVo adminProfile, EmgStudentVo studentProfile, EmgLeturerVo leturerProfile) {
        this.adminProfile = adminProfile;
        this.studentProfile = studentProfile;
        this.leturerProfile = leturerProfile;
    }


    public EmgLeturerVo(long lecturerId, String lecturerName, String lecturerDepartment, String userId) {
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.lecturerDepartment = lecturerDepartment;
        this.userId = userId;
    }


    public EmgLeturerVo() {
    }

    public long getLecturerId() {

        return lecturerId;
    }

    public void setLecturerId(long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerDepartment() {
        return lecturerDepartment;
    }

    public void setLecturerDepartment(String lecturerDepartment) {
        this.lecturerDepartment = lecturerDepartment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
