package com.Sohrab.demo_0.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;



    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "student"
    )
    private List<StudentCourseEnrolment> studentCourseEnrolments = new ArrayList<>();



    @OneToMany(
            mappedBy = "student",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private List<Answer> answers = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String fullName, String email, String password) {
        this.name = name;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Student(Long id, String name, String fullName, String email, String password) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<StudentCourseEnrolment> getStudentCourseEnrolments() {
        return studentCourseEnrolments;
    }

    public void setStudentCourseEnrolments(List<StudentCourseEnrolment> studentCourseEnrolments) {
        this.studentCourseEnrolments = studentCourseEnrolments;
    }

    public void addStudentCourseEnrolment(StudentCourseEnrolment enrolment) {
        if (!studentCourseEnrolments.contains(enrolment)) {
            studentCourseEnrolments.add(enrolment);
        }
    }
    public void removeStudentCourseEnrolment(StudentCourseEnrolment enrolment){
        studentCourseEnrolments.remove(enrolment);
    }
    public void addAnswer(Answer answer){
        if(!answers.contains(answer)){
            answers.add(answer);
            answer.setStudent(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
