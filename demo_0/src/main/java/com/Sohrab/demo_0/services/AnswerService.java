package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.domain.Answer;
import com.Sohrab.demo_0.domain.Homework;
import com.Sohrab.demo_0.domain.Student;
import com.Sohrab.demo_0.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


}
