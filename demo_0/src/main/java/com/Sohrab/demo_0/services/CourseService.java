package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.domain.*;
import com.Sohrab.demo_0.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private HomeworkRepository homeworkRepository;
    private ResourceRepository resourceRepository;
    private ProfessorRepository professorRepository;
    private StudentRepository studentRepository;
    private EnrolmentRepository enrolmentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         HomeworkRepository homeworkRepository,
                         ResourceRepository resourceRepository,
                         ProfessorRepository professorRepository,
                         StudentRepository studentRepository,
                         EnrolmentRepository enrolmentRepository) {
        this.courseRepository = courseRepository;
        this.homeworkRepository = homeworkRepository;
        this.resourceRepository = resourceRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addHomework(Long courseId,
                            Homework homework,
                            HomeworkFile homeworkFile){
        Course course = courseRepository.getOne(courseId);
        homework.setCourse(course);
        homework.setHomeworkFile(homeworkFile);
        homeworkRepository.save(homework);
    }

    public void addResource(Long courseId,
                            Resource resource){
        Course course = courseRepository.getOne(courseId);
        course.addResource(resource);
        resourceRepository.save(resource);
    }

    public void addCourseToProfessor(Long professorId, String courseName,String courseCode){
        Professor professor = professorRepository.getOne(professorId);
        Course course = new Course(courseName,courseCode,professor);
        courseRepository.save(course);
    }

    public void deleteCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void addStudent(Long studentId,Long courseId,String courseCode){
        Student student = studentRepository.getOne(studentId);
        Course course = courseRepository.getOne(courseId);

        StudentCourseEnrolmentId studentCourseEnrolmentId
                =new StudentCourseEnrolmentId(studentId,courseId);

        StudentCourseEnrolment studentCourseEnrolment=
                new StudentCourseEnrolment(studentCourseEnrolmentId,student,course,
                        LocalDateTime.now());
        course.addEnrolmentWithStudent(studentCourseEnrolment);
    }
}
