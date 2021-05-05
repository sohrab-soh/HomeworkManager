package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.repositories.HomeworkFileRepository;
import com.Sohrab.demo_0.repositories.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkFileService {
    private HomeworkFileRepository homeworkFileRepository;

    @Autowired
    public HomeworkFileService(HomeworkFileRepository homeworkFileRepository) {
        this.homeworkFileRepository = homeworkFileRepository;
    }
    
}
