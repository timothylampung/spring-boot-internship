package com.timothy.internship.M_identity.domain.model;


import javax.persistence.*;

@Entity
@Table(name = "dt_lecturer")
public class EmgIdentityLecturerImpl implements EmgIdentity {

    @Id
    @GeneratedValue
    @Column(name = "dt_lecturer_id")
    private long lecturerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dt_lecturer_user_id")
    private EmgUserImpl actor;
    @Column(name="dt_lecturer_name")
    private String lecturerName;
    @Column(name="dt_lecturer_department")
    private String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmgIdentityLecturerImpl() {
    }


    @Override
    public void setActor(EmgUser actor) {

    }

    @Override
    public EmgUser getActor() {
        return this.actor;
    }
}
