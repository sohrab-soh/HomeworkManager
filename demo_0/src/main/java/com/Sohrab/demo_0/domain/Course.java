package com.Sohrab.demo_0.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Course")
@Table(name = "course",
        uniqueConstraints = @UniqueConstraint(name = "course_code_unique", columnNames = "code")
)
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
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
            name = "code",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String code;



    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "course"
    )
    private  List<StudentCourseEnrolment> studentCourseEnrolments = new ArrayList<>();


    public void addStudentCourseEnrolment(StudentCourseEnrolment enrolment) {
        if (!studentCourseEnrolments.contains(enrolment)) {
            studentCourseEnrolments.add(enrolment);
        }
    }

    public void removeStudentCourseEnrolment(StudentCourseEnrolment enrolment){
        studentCourseEnrolments.remove(enrolment);
    }

    @ManyToOne
    @JoinColumn(
            name = "professor_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "professor_course_fk"
            )
    )
    private Professor professor;

    @OneToMany(
            mappedBy = "course",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Homework> homeWorks = new ArrayList<>();

    @OneToMany(
            mappedBy = "course",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Resource> resources = new ArrayList<>();







    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(String name, String code, Professor professor) {
        this.name = name;
        this.code = code;
        this.professor = professor;
    }

    public Course() {
    }


    public Course(String name, String code, List<StudentCourseEnrolment> studentCourseEnrolments) {
        this.name = name;
        this.code = code;
        this.studentCourseEnrolments = studentCourseEnrolments;
    }

    public Course(Long id, String name, String code, List<StudentCourseEnrolment> studentCourseEnrolments) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.studentCourseEnrolments = studentCourseEnrolments;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<StudentCourseEnrolment> getStudentCourseEnrolments() {
        return studentCourseEnrolments;
    }

    public void setStudentCourseEnrolments(List<StudentCourseEnrolment> studentCourseEnrolments) {
        this.studentCourseEnrolments = studentCourseEnrolments;
    }

    public void addEnrolmentWithStudent(StudentCourseEnrolment studentCourseEnrolment){
        if(!studentCourseEnrolments.contains(studentCourseEnrolment)){
            this.studentCourseEnrolments.add(studentCourseEnrolment);
        }
    }
    public void removeEnrolmentWithStudent(StudentCourseEnrolment studentCourseEnrolment){
        studentCourseEnrolments.remove(studentCourseEnrolment);
    }


    public void addHomework(Homework homework){
        if(!this.homeWorks.contains(homework)){
            this.homeWorks.add(homework);
            homework.setCourse(this);
        }
    }
    public void removeHomework(Homework homework){
        if(this.homeWorks.contains(homework)){
            this.homeWorks.remove(homework);
            homework.setCourse(null);
        }
    }

    public void addResource(Resource resource){
        if(!this.resources.contains(resource)){
            this.resources.add(resource);
            resource.setCourse(this);
        }
    }

    public void removeResource(Resource resource){
        if(this.resources.contains(homeWorks)){
            this.resources.remove(resource);
            resource.setCourse(null);
        }
    }








    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

