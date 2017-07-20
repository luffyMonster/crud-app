package com.dn.service;

import com.dn.model.Student;
import com.dn.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    public Student findByStudentCode(String code) {
        return studentRepository.findByStudentCode(code);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student){
        saveStudent(student);
    }

    public void deleteStudentById(Long id){
        studentRepository.delete(id);
    }

    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public boolean isStudentExist(Student student) {
        return findByStudentCode(student.getStudentCode()) != null;
    }

}