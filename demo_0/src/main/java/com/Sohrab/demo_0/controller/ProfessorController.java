package com.Sohrab.demo_0.controller;

import com.Sohrab.demo_0.domain.Professor;
import com.Sohrab.demo_0.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController {
   private ProfessorService professorService;

   @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessor(){
       return professorService.getAllProfessors();
    }

}
