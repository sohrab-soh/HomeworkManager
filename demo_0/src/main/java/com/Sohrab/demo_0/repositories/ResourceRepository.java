package com.Sohrab.demo_0.repositories;

import com.Sohrab.demo_0.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
