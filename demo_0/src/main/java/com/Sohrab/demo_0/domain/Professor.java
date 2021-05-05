package com.Sohrab.demo_0.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Professor")
@Table(
        name = "professor",
        uniqueConstraints = {@UniqueConstraint(
                name = "professor_unique_email", columnNames = "email"
        )}
)
public class Professor {

    @Id
    @SequenceGenerator(
            name = "professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "VARCHAR(50)"
    )
    private String name;

    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "VARCHAR(70)"
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
            mappedBy = "professor",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Course> courses = new ArrayList<>();

    public Professor() {
    }

    public Professor(String name, String fullName, String email, String password) {
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

    public void addCourse(Course course) {
        if(!courses.contains(course)){
            courses.add(course);
            course.setProfessor(this);
        }
    }

    public void removeCourse(Course course){
        if(courses.contains(course)) {
            this.courses.remove(course);
            course.setProfessor(null);
        }
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
