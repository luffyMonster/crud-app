package com.dn.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;

    @NotEmpty
    @Column(name="STUDENT_CODE", nullable=false)
    private String studentCode;

    @Column(name="BIRTHDAY", nullable=false)
    private String birthday;

    @Column(name="ID_NUMBER", nullable=false)
    private Long idNumber;

    @Column(name="Adress", nullable=false)
    private String adress;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentNumber) {
        this.studentCode = studentNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}