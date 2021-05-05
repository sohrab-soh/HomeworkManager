package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
