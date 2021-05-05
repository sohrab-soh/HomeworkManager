package com.Sohrab.demo_0.services;

import com.Sohrab.demo_0.domain.Answer;
import com.Sohrab.demo_0.domain.AnswerFile;
import com.Sohrab.demo_0.domain.Homework;
import com.Sohrab.demo_0.domain.Student;
import com.Sohrab.demo_0.repositories.AnswerRepository;
import com.Sohrab.demo_0.repositories.HomeworkRepository;
import com.Sohrab.demo_0.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkService {
   private HomeworkRepository homeworkRepository;
   private StudentRepository studentRepository;
   private AnswerRepository answerRepository;

    @Autowired
    public HomeworkService(HomeworkRepository homeworkRepository,
                           AnswerRepository answerRepository,
                           StudentRepository studentRepository) {
        this.homeworkRepository = homeworkRepository;
        this.answerRepository = answerRepository;
        this.studentRepository = studentRepository;
    }


    public void addAnswer(Long studentId,
                          Long homeworkId,
                          Answer answer){
        Student student = studentRepository.getOne(studentId);
        Homework homework = homeworkRepository.getOne(homeworkId);
        answer.setHomework(homework);
        answer.setStudent(student);
        answerRepository.save(answer);
    }

    public void deleteHomework(Long homeworkId) {
        homeworkRepository.deleteById(homeworkId);
    }

}
