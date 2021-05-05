package com.Sohrab.demo_0.domain;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "homework")
@Entity(name = "Homework")
public class Homework {

    @Id
    @SequenceGenerator(
            name = "homework_sequence",
            sequenceName = "homework_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "homework_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(
            name = "description",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "final_time",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime finalTime;


    @ManyToOne
    @JoinColumn(
            name = "course_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "course_homework_fk"
            )
    )
    private Course course;



    @OneToOne(
            mappedBy = "homework",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private HomeworkFile homeworkFile;




    @OneToOne(
            mappedBy = "homework",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}

    )
    private Answer answer;





    public Homework() {
    }

    public Homework(String description, LocalDateTime finalTime) {
        this.description = description;
        this.finalTime = finalTime;
    }

    public Homework(String description, LocalDateTime finalTime, Course course) {
        this.description = description;
        this.finalTime = finalTime;
        this.course = course;
    }

    public Homework(Long id, String description, LocalDateTime finalTime, Course course) {
        this.id = id;
        this.description = description;
        this.finalTime = finalTime;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(LocalDateTime finalTime) {
        this.finalTime = finalTime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public HomeworkFile getHomeworkFile() {
        return homeworkFile;
    }

    public void setHomeworkFile(HomeworkFile homeworkFile) {
        this.homeworkFile = homeworkFile;
        homeworkFile.setHomework(this);
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        answer.setHomework(this);
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", finalTime=" + finalTime +
                ", course=" + course +
                '}';
    }


}

