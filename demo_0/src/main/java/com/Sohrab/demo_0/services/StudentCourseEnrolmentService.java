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
public class StudentCourseEnrolmentService {
    private EnrolmentRepository enrolmentRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Autowired
    public StudentCourseEnrolmentService(EnrolmentRepository enrolmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrolmentRepository = enrolmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<StudentCourseEnrolment> getAllStudentCourseEnrolment(){
        return enrolmentRepository.findAll();
    }

    public void addEnrolment(Long studentId ,String courseCode) {
        Student student = studentRepository.getOne(studentId);
        System.out.println(student);
        Course course = courseRepository.findCoursesByCode(courseCode);
        System.out.println(course);
        StudentCourseEnrolment studentCourseEnrolment = new StudentCourseEnrolment(
                new StudentCourseEnrolmentId(student.getId(),course.getId()),
                student,
                course,
                LocalDateTime.now()
        );
        enrolmentRepository.save(studentCourseEnrolment);
    }



    public void removeEnrolment(Long studentId ,String courseCode) {
        Student student = studentRepository.getOne(studentId);
        System.out.println(student);
        Course course = courseRepository.findCoursesByCode(courseCode);
        System.out.println(course);
        enrolmentRepository.deleteById(new StudentCourseEnrolmentId(student.getId(),course.getId()));
    }
}
