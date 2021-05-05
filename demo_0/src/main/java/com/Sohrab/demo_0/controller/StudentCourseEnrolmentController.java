package com.Sohrab.demo_0.controller;

import com.Sohrab.demo_0.domain.StudentCourseEnrolment;
import com.Sohrab.demo_0.services.StudentCourseEnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/StudentCourseEnrolment")
public class StudentCourseEnrolmentController {
    private StudentCourseEnrolmentService studentCourseEnrolmentService;

    @Autowired
    public StudentCourseEnrolmentController(StudentCourseEnrolmentService studentCourseEnrolmentService) {
        this.studentCourseEnrolmentService = studentCourseEnrolmentService;
    }

    @GetMapping
    public List<StudentCourseEnrolment> getAllStudentCourseEnrolment() {
        return studentCourseEnrolmentService.getAllStudentCourseEnrolment();
    }



    @GetMapping(path = "/add")
    public void addEnrolment(@RequestParam(name ="studentId") Long studentId , @RequestParam(name ="courseCode") String courseCode){
        studentCourseEnrolmentService.addEnrolment(studentId,courseCode);
    }

    @GetMapping(path = "/delete")
    public void deleteEnrolment(@RequestParam(name ="studentId") Long studentId , @RequestParam(name ="courseCode") String courseCode){
        studentCourseEnrolmentService.removeEnrolment(studentId,courseCode);
    }

}
