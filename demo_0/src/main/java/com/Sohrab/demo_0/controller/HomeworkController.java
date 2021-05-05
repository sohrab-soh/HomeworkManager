package com.Sohrab.demo_0.controller;

import com.Sohrab.demo_0.domain.Answer;
import com.Sohrab.demo_0.domain.AnswerFile;
import com.Sohrab.demo_0.domain.Homework;
import com.Sohrab.demo_0.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/homework")
public class HomeworkController {
    private HomeworkService homeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @PostMapping(path = "/{stuId}/{hwId}/addAnswer")
    public void addAnswer(@PathVariable(name = "stuId")Long studentId,
                          @PathVariable(name = "hwId")Long homeworkId,
                          @RequestParam(name = "answerDescription")String answerDescription,
                          @RequestParam(name = "file") MultipartFile file){

        AnswerFile answerFile = new AnswerFile();
        answerFile.setFileName(StringUtils.cleanPath(file.getOriginalFilename()));
        try{
            answerFile.setFile(file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Answer answer = new Answer(answerDescription);
        answer.setAnswerFile(answerFile);

        homeworkService.addAnswer(studentId,homeworkId,answer);
    }

    @DeleteMapping(path = "/deleteHomework/{homeworkId}")
    public void deleteHomework(
            @PathVariable(name = "homeworkId") Long homeworkId){
        homeworkService.deleteHomework(homeworkId);
    }




}
