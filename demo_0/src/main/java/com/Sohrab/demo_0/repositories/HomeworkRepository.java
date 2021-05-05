package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Long> {

}
