package com.web.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_INFO")
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    private int studentId;
    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "FATHER_NAME")
    private String fatherName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "MOBILE")
    private long mobile;
    @Column(name = "CATEGORY")
    private String category;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
