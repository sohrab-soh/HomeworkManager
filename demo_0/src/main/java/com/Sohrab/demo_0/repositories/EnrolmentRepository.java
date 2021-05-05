package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.StudentCourseEnrolment;
import com.Sohrab.demo_0.domain.StudentCourseEnrolmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends JpaRepository<StudentCourseEnrolment, StudentCourseEnrolmentId> {

}
