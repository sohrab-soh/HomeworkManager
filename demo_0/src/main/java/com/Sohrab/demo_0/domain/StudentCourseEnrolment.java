package com.Sohrab.demo_0.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "StudentCourseEnrolment")
@Table(name = "student_course_enrolment" )
public class StudentCourseEnrolment {

    @EmbeddedId
    private StudentCourseEnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;

    @Column(
            name = "created_at",
            nullable = true,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;


    public StudentCourseEnrolment(StudentCourseEnrolmentId id, Student student, Course course, LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public StudentCourseEnrolment(Student student, Course course, LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public StudentCourseEnrolment(){

    }

    public StudentCourseEnrolment(StudentCourseEnrolmentId id, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public StudentCourseEnrolment(StudentCourseEnrolmentId id) {
        this.id = id;
    }

    public StudentCourseEnrolmentId getId() {
        return id;
    }

    public void setId(StudentCourseEnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseEnrolment that = (StudentCourseEnrolment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

