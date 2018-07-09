package com.timothy.internship.M_identity.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "dt_student")
public class EmgIdentityStudentImpl implements EmgIdentity {

    @Id
    @GeneratedValue
    @Column(name = "dt_student_user_id")
    private
    long studentId;

    @Column(name = "dt_student_matric")
    private
    String studentMatric;

    @Column(name = "dt_student_ic")
    private
    String studentIcNo;

    @Column(name = "dt_student_course")
    private
    String studentCourse;

    @Column(name = "dt_student_cgpa")
    private
    String studentCgpa;

    @Column(name = "dt_student_department")
    private
    String studentDepartment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dt_student_user_id")
    private EmgUserImpl actor;


    public EmgIdentityStudentImpl() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentMatric() {
        return studentMatric;
    }

    public void setStudentMatric(String studentMatric) {
        this.studentMatric = studentMatric;
    }

    public String getStudentIcNo() {
        return studentIcNo;
    }

    public void setStudentIcNo(String studentIcNo) {
        this.studentIcNo = studentIcNo;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentCgpa() {
        return studentCgpa;
    }

    public void setStudentCgpa(String studentCgpa) {
        this.studentCgpa = studentCgpa;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    @Override
    public void setActor(EmgUser actor) {
        this.actor = (EmgUserImpl) actor;
    }
    @Override
    public EmgUser getActor() {
        return this.actor;
    }
}
