package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findCoursesByCode(String code);
}
