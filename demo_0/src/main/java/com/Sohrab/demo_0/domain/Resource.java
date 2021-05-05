package com.Sohrab.demo_0.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "resource")
@Entity(name = "Resource")
public class Resource {
    @Id
    @SequenceGenerator(
            name = "resource_sequence",
            sequenceName = "resource_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resource_sequence"
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

    @Column(
            name = "description",
            columnDefinition = "TEXT",
            nullable = true
    )
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "course_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "resource_homework_fk"
            )
    )
    private Course course;

    public Resource() {
    }

    public Resource(String fileName, String description) {
        this.fileName = fileName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
