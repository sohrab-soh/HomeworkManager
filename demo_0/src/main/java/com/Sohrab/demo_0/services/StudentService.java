package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.domain.Course;
import com.Sohrab.demo_0.domain.Student;
import com.Sohrab.demo_0.domain.StudentCourseEnrolment;
import com.Sohrab.demo_0.domain.StudentCourseEnrolmentId;
import com.Sohrab.demo_0.repositories.CourseRepository;
import com.Sohrab.demo_0.repositories.EnrolmentRepository;
import com.Sohrab.demo_0.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrolmentRepository enrolmentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository, EnrolmentRepository enrolmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrolmentRepository = enrolmentRepository;
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
