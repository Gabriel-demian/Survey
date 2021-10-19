package com.demo.survey.repository;

import com.demo.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, String> {

    List<Survey> findSurveysByCreatedBy(String username);

}
