package com.demo.survey.repository;

import com.demo.survey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<SurveyEntity, String> {

    List<SurveyEntity> findSurveysByCreatedBy(String username);

    List<SurveyEntity> findSurveysByLabel(String label);

}
