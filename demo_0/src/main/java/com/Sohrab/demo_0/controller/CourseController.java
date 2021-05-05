package com.Sohrab.demo_0.controller;

import com.Sohrab.demo_0.domain.*;
import com.Sohrab.demo_0.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(
        path = "api/v1/course"
)
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @PostMapping(path = "/{id}/addHomework")
    public void addHomeworkToCourse(@PathVariable("id") Long courseId,
                                    @RequestParam(name = "homeworkDescription") String homeworkDescription,
                                    @RequestParam(name = "file")MultipartFile file){
        HomeworkFile homeworkFile = new HomeworkFile(StringUtils.cleanPath(file.getOriginalFilename()));
        try{
            homeworkFile.setFile(file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Homework homework = new Homework(homeworkDescription,LocalDateTime.now().plusDays(10L));
        courseService.addHomework(courseId,homework,homeworkFile);
    }

    @PostMapping(path = "/{id}/addResource")
    public void addResource(
            @PathVariable("id") Long courseId,
            @RequestParam(name = "resourceDescription") String resourceDescription,
            @RequestParam(name = "file")MultipartFile file){
        Resource resource = new Resource(
                StringUtils.cleanPath(file.getOriginalFilename()),
                resourceDescription);
        try{
            resource.setFile(file.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        courseService.addResource(courseId,resource);
    }

    @GetMapping(path = "/addCourse")
    public void addCourse(@RequestParam(name = "professorId") Long professorId,
                          @RequestParam(name = "courseName") String courseName,
                          @RequestParam(name = "courseCode")String courseCode){
        System.out.println(professorId);
        System.out.println(courseCode);
        System.out.println(courseName);
        courseService.addCourseToProfessor(professorId,courseName,courseCode);
    }

    @GetMapping(path = "/delete/{courseId}")
    public void deleteCourse(@PathVariable(name = "courseId")Long courseId){
        courseService.deleteCourse(courseId);
    }

    @GetMapping(path = "/{courseId}/addStudent/{studentId}")
    public void addStudent(@PathVariable(name = "studentId") Long studentId,
                           @PathVariable(name = "courseId") Long courseId,
                           @RequestParam(name = "courseCode") String courseCode) {
        courseService.addStudent(studentId,courseId,courseCode);
    }

}
