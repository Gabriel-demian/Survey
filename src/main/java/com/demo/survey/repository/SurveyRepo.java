package com.demo.survey.repository;

import com.demo.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo  extends JpaRepository<Survey, String> {



}
