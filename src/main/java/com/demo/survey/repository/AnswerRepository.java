package com.demo.survey.repository;

import com.demo.survey.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, String> {



}
