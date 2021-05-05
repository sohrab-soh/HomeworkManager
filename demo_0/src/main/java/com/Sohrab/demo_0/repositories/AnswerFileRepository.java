package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnswerFileRepository extends JpaRepository<Answer,Long> {

}
