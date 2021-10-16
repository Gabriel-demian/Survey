package com.demo.survey.repository;

import com.demo.survey.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, String> {

    

}
