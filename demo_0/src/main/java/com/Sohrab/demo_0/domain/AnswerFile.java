package com.Sohrab.demo_0.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "answer_file")
@Entity(name = "AnswerFile")
public class AnswerFile {
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
            name = "file_name",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String fileName;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] file;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "answer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "answer_id_fk"
            ),
            nullable = true
    )
    private Answer answer;


    public AnswerFile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "AnswerFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
