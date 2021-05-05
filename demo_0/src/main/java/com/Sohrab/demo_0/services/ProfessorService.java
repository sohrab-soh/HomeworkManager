package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.domain.Course;
import com.Sohrab.demo_0.domain.Professor;
import com.Sohrab.demo_0.repositories.CourseRepository;
import com.Sohrab.demo_0.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    private CourseRepository courseRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository,
                            CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    public void addProfessor(Professor professor){
        professorRepository.save(professor);
    }





}
