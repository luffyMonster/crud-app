package com.dn.controller;

import com.dn.model.Student;
import com.dn.service.StudentService;
import com.dn.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    StudentService studentService;

    // -------------------Retrieve All Students---------------------------------------------

    @RequestMapping(value = "/user/student/", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudents() {
        List<Student> students = studentService.findAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    // -------------------Retrieve Single Student------------------------------------------

    @RequestMapping(value = "/user/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        logger.info("Fetching student with id {}", id);
        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Student with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    // -------------------Create a Student-------------------------------------------

    @RequestMapping(value = "/user/student/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody @Valid Student student, BindingResult result, UriComponentsBuilder ucBuilder) {
        if (result.hasErrors()){
            logger.info("Creating student error!");
            return new ResponseEntity(new CustomErrorType("Student object invalid!"),
                    HttpStatus.FORBIDDEN);
        }


        logger.info("Creating student : {}", student);

        if (studentService.isStudentExist(student)) {
            logger.error("Unable to create. A student with name {} already exist", student.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A student with code " +
                    student.getStudentCode() + " already exist."),HttpStatus.CONFLICT);
        }
        studentService.saveStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Student ------------------------------------------------

    @RequestMapping(value = "/user/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody @Valid Student student, BindingResult result) {
        logger.info("Updating student with id {}", id);
        if (result.hasErrors()){
            logger.info("Update student error");
            return new ResponseEntity(new CustomErrorType("Student object invalid!"),
                    HttpStatus.FORBIDDEN);
        }

        Student currentStudent = studentService.findById(id);

        if (currentStudent == null) {
            logger.error("Unable to update. Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Student with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentStudent.setName(student.getName());
        currentStudent.setBirthday(student.getBirthday());
        currentStudent.setAdress(student.getAdress());
        currentStudent.setIdNumber(student.getIdNumber());
        currentStudent.setStudentCode(student.getStudentCode());

        studentService.updateStudent(currentStudent);
        return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
    }

    // ------------------- Delete a Student-----------------------------------------

    @RequestMapping(value = "/user/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting student with id {}", id);

        Student student = studentService.findById(id);
        if (student == null) {
            logger.error("Unable to delete. Student with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "/user/student/", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteAllStudent() {
        logger.info("Deleting All Students");

        studentService.deleteAllStudents();
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

}