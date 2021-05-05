package com.Sohrab.demo_0.domain;


import javax.persistence.*;

@Table(name = "answer")
@Entity(name = "Answer")
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )
    @Column(name = "id")
    private Long id;



    @Column(
            name = "description",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String description;

    @OneToOne(
            mappedBy = "answer",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    private AnswerFile answerFile;



    @ManyToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "answer_student_fk"
            ),
            nullable = false
    )
    private Student student;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "homework_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "homework_id_fk"
            ),
            nullable = false
    )
    private Homework homework;

    public Answer() {
    }

    public Answer(String description) {
        this.description = description;
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

    public AnswerFile getAnswerFile() {
        return answerFile;
    }

    public void setAnswerFile(AnswerFile answerFile) {
        this.answerFile = answerFile;
        answerFile.setAnswer(this);
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
