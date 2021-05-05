package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.repositories.AnswerFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerFileService {
    private AnswerFileRepository answerFileRepository;

    @Autowired
    public AnswerFileService(AnswerFileRepository answerFileRepository) {
        this.answerFileRepository = answerFileRepository;
    }
}
