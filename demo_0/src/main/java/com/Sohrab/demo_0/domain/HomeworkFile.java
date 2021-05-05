package com.Sohrab.demo_0.domain;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "homework_file")
@Entity(name = "HomeworkFile")
public class HomeworkFile {
    @Id
    @SequenceGenerator(
            name = "homework_file_sequence",
            sequenceName = "homework_file_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "homework_file_sequence"
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
            name = "homework_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "homework_id_fk"
            ),
            nullable = true
    )
    private Homework homework;



    public HomeworkFile() {
    }


    public HomeworkFile(String fileName) {
        this.fileName = fileName;
    }

    public HomeworkFile(String fileName, byte[] file) {
        this.fileName = fileName;
        this.file = file;
    }

    public HomeworkFile(Long id, String fileName, byte[] file) {
        this.id = id;
        this.fileName = fileName;
        this.file = file;
    }

    public HomeworkFile(String fileName, byte[] file, Homework homework) {
        this.fileName = fileName;
        this.file = file;
        this.homework = homework;
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

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "HomeworkFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
