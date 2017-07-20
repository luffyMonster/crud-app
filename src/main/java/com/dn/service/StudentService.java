package com.dn.service;

import com.dn.model.Student;

import java.util.List;

public interface StudentService {

    Student findById(Long id);

    Student findByStudentCode(String code);

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Long id);

    void deleteAllStudents();

    List<Student> findAllStudents();

    boolean isStudentExist(Student student);
}